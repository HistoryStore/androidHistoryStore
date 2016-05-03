package com.icaboalo.historystore.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.icaboalo.historystore.PurchaseApiModel
import com.icaboalo.historystore.R
import com.icaboalo.historystore.ui.adapter.CustomPlaceSpinnerAdapter
import com.icaboalo.historystore.ui.adapter.ProductAutoCompleteAdapter
import com.icaboalo.historystore.io.ApiClient
import com.icaboalo.historystore.io.CategoryApiModel
import com.icaboalo.historystore.io.PlaceApiModel
import com.icaboalo.historystore.io.ProductApiModel
import com.icaboalo.historystore.ui.adapter.ProductRecyclerAdapter
import kotlinx.android.synthetic.main.activity_edit_purchase.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class EditPurchaseActivity : AppCompatActivity() {

    var mProductList: ArrayList<ProductApiModel>? = null
    var mPurchase: PurchaseApiModel? = null
    var mProductRecyclerAdapter: ProductRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_purchase)
        mPurchase = intent.extras.getSerializable("MODEL") as PurchaseApiModel
        val nToolbar = findViewById(R.id.app_bar) as Toolbar?
        setSupportActionBar(nToolbar)
        supportActionBar!!.title = "Edit ${mPurchase!!.mPurchaseDate}"
        setupProductRecycler(mPurchase!!.mProducts)
        getPlacesRetrofit("")
        getCategoriesRetrofit("")
    }

    override fun onResume() {
        super.onResume()
        add_product_button.setOnClickListener {
            if (!product_input.text.isEmpty()){
                if (mProductList != null){
                    val productPosition = getPosition(mProductList!!, product_input.text.toString())
                    val product: ProductApiModel = mProductList!![productPosition]
                    mPurchase!!.mProducts.add(product)
                    mProductRecyclerAdapter!!.notifyDataSetChanged()
                    product_input.setText("")
                    Log.d("ADDED", mPurchase!!.mProducts.toString())
                }
            }else product_input.error = "Can't be blank"
        }
        save_purchase_button.setOnClickListener {
            mPurchase!!.mPlace = place_spinner.selectedItem as PlaceApiModel
            putPurchaseRetrofit("", "${mPurchase!!.mId!!}", mPurchase!!)
        }
    }

    fun getPosition(productList: ArrayList<ProductApiModel>, productName: String): Int{
        for (product in productList){
            if (product.mName.equals(productName)){
                return productList.indexOf(product)
            }
        }
        return -1
    }

    fun setupProductRecycler(productList: ArrayList<ProductApiModel>){
        val linearLayout: LinearLayoutManager = LinearLayoutManager(this@EditPurchaseActivity)
        mProductRecyclerAdapter = ProductRecyclerAdapter(this@EditPurchaseActivity, productList)
        product_recycler!!.layoutManager = linearLayout
        product_recycler!!.adapter = mProductRecyclerAdapter
    }


    fun setupPlaceSpinner(placeList: ArrayList<PlaceApiModel>){
        val arrayAdapter: CustomPlaceSpinnerAdapter = CustomPlaceSpinnerAdapter(this@EditPurchaseActivity, R.layout.custom_place_dropdown, placeList)
        place_spinner.adapter = arrayAdapter
        place_spinner.setSelection(equalObjects(placeList))
    }

    fun equalObjects(placeList: ArrayList<PlaceApiModel>): Int{
        for (place in placeList){
            if (place.mAddress.equals(mPurchase!!.mPlace!!.mAddress)){
                return placeList.indexOf(place)
            }
        }
        return -1
    }

    fun setupCategorySpinner(categoryList: ArrayList<CategoryApiModel>){
        val arrayAdapter: ArrayAdapter<CategoryApiModel> = ArrayAdapter(this@EditPurchaseActivity, android.R.layout.simple_spinner_dropdown_item, categoryList)
        category_spinner.adapter = arrayAdapter
        category_spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                product_input.setAdapter(ProductAutoCompleteAdapter(this@EditPurchaseActivity, android.R.layout.simple_spinner_dropdown_item, categoryList[position].mProducts!!))
                product_input.threshold = 1
                mProductList = categoryList[position].mProducts!!
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    fun getPlacesRetrofit(token: String){
        val call: Call<ArrayList<PlaceApiModel>> = ApiClient().getApiService().getPlaceList()
        call.enqueue(object: Callback<ArrayList<PlaceApiModel>> {
            override fun onResponse(call: Call<ArrayList<PlaceApiModel>>, response: Response<ArrayList<PlaceApiModel>>) {
                if (response.isSuccessful){
                    setupPlaceSpinner(response.body())
                }
            }

            override fun onFailure(call: Call<ArrayList<PlaceApiModel>>, t: Throwable) {

            }
        })
    }

    fun getCategoriesRetrofit(token: String){
        val call: Call<ArrayList<CategoryApiModel>> = ApiClient().getApiService().getCategoryList()
        call.enqueue(object: Callback<ArrayList<CategoryApiModel>> {
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

    fun putPurchaseRetrofit(token: String, purchaseId: String, purchase: PurchaseApiModel){
        val call: Call<PurchaseApiModel> = ApiClient().getApiService().putPurchase(purchaseId, purchase)
        call.enqueue(object: Callback<PurchaseApiModel> {
            override fun onResponse(call: Call<PurchaseApiModel>, response: Response<PurchaseApiModel>) {
                if (response.isSuccessful){
                    finish()
                }else{
                    val errorBody = response.errorBody()
                    Log.d("ERROR", errorBody.string())
                }
            }

            override fun onFailure(call: Call<PurchaseApiModel>?, t: Throwable?) {
                throw UnsupportedOperationException()
            }
        })
    }
}
