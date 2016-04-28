package com.icaboalo.historystore.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import com.icaboalo.historystore.PurchaseApiModel
import com.icaboalo.historystore.R
import java.util.*

/**
 * Created by icaboalo on 27/04/16.
 */
class PurchaseRecyclerAdapter: RecyclerView.Adapter<PurchaseRecyclerAdapter.PurchaseViewHolder> {

    var mContext: Context
    var mPurchaseList: ArrayList<PurchaseApiModel>
    var mInflater: LayoutInflater

    constructor(context: Context, purchaseList: ArrayList<PurchaseApiModel>) : super() {
        this.mContext = context
        this.mPurchaseList = purchaseList
        mInflater = LayoutInflater.from(context)
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PurchaseViewHolder? {
        val view = mInflater.inflate(R.layout.item_purchases, parent, false)
        val viewHolder: PurchaseViewHolder = PurchaseViewHolder(view, R.id.purchase_date_text, R.id.status_checkbox)
        return viewHolder
    }

    override fun onBindViewHolder(holder: PurchaseViewHolder, position: Int) {
        val purchase: PurchaseApiModel = mPurchaseList[position]
        holder.mPurchaseDate.text = purchase.mPurchaseDate
        holder.mStatusCheckbox.isChecked = purchase.mStatus

    }

    override fun getItemCount(): Int {
        return mPurchaseList.size
    }

    class PurchaseViewHolder: RecyclerView.ViewHolder {

        var mPurchaseDate: TextView
        var mStatusCheckbox: CheckBox

        constructor(itemView: View, purchaseDateId: Int, statusCheckboxId: Int) : super(itemView){
            mPurchaseDate = itemView.findViewById(purchaseDateId) as TextView
            mStatusCheckbox = itemView.findViewById(statusCheckboxId) as CheckBox
        }
    }
}