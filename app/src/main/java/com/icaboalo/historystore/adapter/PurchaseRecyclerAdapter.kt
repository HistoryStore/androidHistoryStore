package com.icaboalo.historystore.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.icaboalo.historystore.PurchasesApiModel
import com.icaboalo.historystore.R
import java.util.*

/**
 * Created by icaboalo on 27/04/16.
 */
class PurchaseRecyclerAdapter: RecyclerView.Adapter<PurchaseRecyclerAdapter.PurchaseViewHolder> {

    var mContext: Context
    var mPurchaseList: ArrayList<PurchasesApiModel>
    var mInflater: LayoutInflater

    constructor(context: Context, purchaseList: ArrayList<PurchasesApiModel>) : super() {
        this.mContext = context
        this.mPurchaseList = purchaseList
        mInflater = LayoutInflater.from(context)
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PurchaseViewHolder? {
        val view = mInflater.inflate(R.layout.item_purchases, parent, false)
        val viewHolder: PurchaseViewHolder = PurchaseViewHolder(view, R.id.purchase_date_text)
        return viewHolder
    }

    override fun onBindViewHolder(holder: PurchaseViewHolder, position: Int) {
        val purchase: PurchasesApiModel = mPurchaseList[position]
        holder.mPurchaseDate.text = purchase.date

    }

    override fun getItemCount(): Int {
        return mPurchaseList.size
    }

    class PurchaseViewHolder: RecyclerView.ViewHolder {

        var mPurchaseDate: TextView

        constructor(itemView: View, purchaseDate: Int) : super(itemView){
            mPurchaseDate = itemView.findViewById(purchaseDate) as TextView
        }
    }
}