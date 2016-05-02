package com.icaboalo.historystore.ui.fragment

import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.Bind
import butterknife.ButterKnife
import com.icaboalo.historystore.PurchaseApiModel
import com.icaboalo.historystore.R
import com.icaboalo.historystore.ui.adapter.OnViewHolderClick
import com.icaboalo.historystore.ui.adapter.PurchaseRecyclerAdapter
import com.icaboalo.historystore.ui.fragment.dialog.PurchaseDetailDialog
import com.icaboalo.historystore.io.ApiClient
import com.icaboalo.historystore.io.ProductApiModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * Created by icaboalo on 27/04/16.
 */
class PurchasesFragment: Fragment() {

    var mPurchaseRecycler: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_purchases, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPurchaseRecycler = view.findViewById(R.id.purchase_recycler) as RecyclerView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getPurchaseListRetrofit()
    }

    fun getPurchaseListRetrofit(){
        val call: Call<ArrayList<PurchaseApiModel>> = ApiClient().getApiService().getPurchaseList()
        call.enqueue(object: Callback<ArrayList<PurchaseApiModel>> {

            override fun onResponse(call: Call<ArrayList<PurchaseApiModel>>, response: Response<ArrayList<PurchaseApiModel>>) {
                Log.d("RESPONSE", "" + response.isSuccessful)
                if (response.isSuccessful){
                    setupPurchaseRecycler(response.body())
                }
            }

            override fun onFailure(call: Call<ArrayList<PurchaseApiModel>>, t: Throwable) {

            }
        })

    }

    fun setupPurchaseRecycler(purchasesList: ArrayList<PurchaseApiModel>) {

        val purchaseRecyclerAdapter = PurchaseRecyclerAdapter(activity, purchasesList, object: OnViewHolderClick{
            override fun onClick(view: View, position: Int) {
                Log.d("ba", purchasesList[position].mPlace?.mAddress)
                Log.d("ba", purchasesList[position].mPurchaseDate)
                showDialog(purchasesList[position])
            }

        })

        val linearLayout = LinearLayoutManager(activity)
        mPurchaseRecycler!!.adapter = purchaseRecyclerAdapter
        mPurchaseRecycler!!.layoutManager = linearLayout
    }

    fun showDialog(purchase: PurchaseApiModel){
        val alertDialog = PurchaseDetailDialog().newInstance(purchase)
        alertDialog.show(activity.supportFragmentManager, "Purchase Detail")
    }
}