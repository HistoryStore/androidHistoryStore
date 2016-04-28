package com.icaboalo.historystore.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.*

/**
 * Created by icaboalo on 27/04/16.
 */
class PurchaseRecyclerAdapter: RecyclerView.Adapter<PurchaseRecyclerAdapter.PurchaseViewHolder> {

    var mContext: Context
    var mPurchaseList: ArrayList<String>
    var mInflater: LayoutInflater? = null

    constructor(context: Context, purchaseList: ArrayList<String>) : super() {
        this.mContext = context
        this.mPurchaseList = purchaseList
        mInflater = LayoutInflater.from(context)
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PurchaseViewHolder? {
        throw UnsupportedOperationException()
    }

    override fun onBindViewHolder(holder: PurchaseViewHolder?, position: Int) {

    }

    override fun getItemCount(): Int {
        return mPurchaseList.size
    }

    class PurchaseViewHolder: RecyclerView.ViewHolder {

        constructor(itemView: View?) : super(itemView){

        }
    }
}