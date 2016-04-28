package com.icaboalo.historystore.fragment

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
import com.icaboalo.historystore.adapter.PurchaseRecyclerAdapter
import com.icaboalo.historystore.io.ApiClient
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
        ButterKnife.bind(this@PurchasesFragment, view)
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
                if (response.isSuccessful){
                    setupPurchaseRecycler(response.body())
                }
            }

            override fun onFailure(call: Call<ArrayList<PurchaseApiModel>>?, t: Throwable?) {
                throw UnsupportedOperationException()
            }
        })

    }

    fun setupPurchaseRecycler(purchasesList: ArrayList<PurchaseApiModel>) {
        val purchaseRecyclerAdapter = PurchaseRecyclerAdapter(activity, purchasesList)
        val linearLayout = LinearLayoutManager(activity)
        mPurchaseRecycler!!.adapter = purchaseRecyclerAdapter
        mPurchaseRecycler!!.layoutManager = linearLayout
    }
}