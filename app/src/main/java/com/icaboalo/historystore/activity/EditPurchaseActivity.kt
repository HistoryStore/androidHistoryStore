package com.icaboalo.historystore.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.util.Log
import android.widget.ArrayAdapter
import com.icaboalo.historystore.PurchaseApiModel
import com.icaboalo.historystore.R
import com.icaboalo.historystore.adapter.CustomPlaceSpinnerAdapter
import com.icaboalo.historystore.adapter.ProductAutoCompleteAdapter
import com.icaboalo.historystore.adapter.ProductRecyclerAdapter
import com.icaboalo.historystore.io.ApiClient
import com.icaboalo.historystore.io.CategoryApiModel
import com.icaboalo.historystore.io.PlaceApiModel
import com.icaboalo.historystore.io.ProductApiModel
import kotlinx.android.synthetic.main.activity_edit_purchase.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class EditPurchaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_purchase)
        val nToolbar = findViewById(R.id.app_bar) as Toolbar?
        setSupportActionBar(nToolbar)
        supportActionBar!!.title = "Edit ${getPurchase().mPurchaseDate}"
        setupProductRecycler(getPurchase().mProducts)
        getPlacesRetrofit("")
        getProductsRetrofit("")
        getCategoriesRetrofit("")
    }

    fun setupProductRecycler(productList: ArrayList<ProductApiModel>){
        val linearLayout: LinearLayoutManager = LinearLayoutManager(this@EditPurchaseActivity)
        val productRecyclerAdapter: ProductRecyclerAdapter = ProductRecyclerAdapter(this@EditPurchaseActivity, productList)
        product_recycler!!.layoutManager = linearLayout
        product_recycler!!.adapter = productRecyclerAdapter
    }

    fun getPurchase(): PurchaseApiModel{
        return intent.extras.getSerializable("MODEL") as PurchaseApiModel
    }

    fun setupPlaceSpinner(placeList: ArrayList<PlaceApiModel>){
        val arrayAdapter: CustomPlaceSpinnerAdapter = CustomPlaceSpinnerAdapter(this@EditPurchaseActivity, R.layout.custom_place_dropdown, placeList)
        place_spinner.adapter = arrayAdapter
        place_spinner.setSelection(equalObjects(placeList))
    }

    fun equalObjects(placeList: ArrayList<PlaceApiModel>): Int{
        for (place in placeList){
            if (place.mAddress.equals(getPurchase().mPlace!!.mAddress)){
                return placeList.indexOf(place)
            }
        }
        return -1
    }

    fun setupCategorySpinner(categoryList: ArrayList<CategoryApiModel>){
        val arrayAdapter: ArrayAdapter<CategoryApiModel> = ArrayAdapter(this@EditPurchaseActivity, android.R.layout.simple_spinner_dropdown_item, categoryList)
        category_spinner.adapter = arrayAdapter
    }

    fun getPlacesRetrofit(token: String){
        val call: Call<ArrayList<PlaceApiModel>> = ApiClient().getApiService().getPlaceList()
        call.enqueue(object: Callback<ArrayList<PlaceApiModel>>{
            override fun onResponse(call: Call<ArrayList<PlaceApiModel>>, response: Response<ArrayList<PlaceApiModel>>) {
                if (response.isSuccessful){
                    setupPlaceSpinner(response.body())
                }
            }

            override fun onFailure(call: Call<ArrayList<PlaceApiModel>>, t: Throwable) {

            }
        })
    }

    fun getProductsRetrofit(token: String){
        val call: Call<ArrayList<ProductApiModel>> = ApiClient().getApiService().getProductList()
        call.enqueue(object: Callback<ArrayList<ProductApiModel>>{
            override fun onResponse(call: Call<ArrayList<ProductApiModel>>, response: Response<ArrayList<ProductApiModel>>) {
                if (response.isSuccessful){
                    product_input.setAdapter(ProductAutoCompleteAdapter(this@EditPurchaseActivity, android.R.layout.simple_spinner_dropdown_item, response.body()))
                    product_input.threshold = 1
                    Log.d("READY", "Ready")
                }
            }

            override fun onFailure(call: Call<ArrayList<ProductApiModel>>, t: Throwable) {
                throw UnsupportedOperationException()
            }
        })
    }

    fun getCategoriesRetrofit(token: String){
        val call: Call<ArrayList<CategoryApiModel>> = ApiClient().getApiService().getCategoryList()
        call.enqueue(object: Callback<ArrayList<CategoryApiModel>>{
            override fun onResponse(call: Call<ArrayList<CategoryApiModel>>, response: Response<ArrayList<CategoryApiModel>>) {
                if (response.isSuccessful){
                    setupCategorySpinner(response.body())
                }
            }

            override fun onFailure(call: Call<ArrayList<CategoryApiModel>>?, t: Throwable?) {
                throw UnsupportedOperationException()
            }
        })
    }
}
