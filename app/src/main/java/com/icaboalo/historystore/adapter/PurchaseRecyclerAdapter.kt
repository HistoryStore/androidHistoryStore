package com.icaboalo.historystore.adapter

import android.content.Context
import android.content.DialogInterface
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
    var mViewHolderClick: OnViewHolderClick

    constructor(context: Context, purchaseList: ArrayList<PurchaseApiModel>, viewHolderClick: OnViewHolderClick) : super() {
        this.mContext = context
        this.mPurchaseList = purchaseList
        this.mViewHolderClick = viewHolderClick
        mInflater = LayoutInflater.from(context)
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PurchaseViewHolder? {
        val view = mInflater.inflate(R.layout.item_purchases, parent, false)
        val viewHolder: PurchaseViewHolder = PurchaseViewHolder(view, R.id.purchase_date_text, R.id.status_checkbox, mViewHolderClick)
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

    class PurchaseViewHolder: RecyclerView.ViewHolder, View.OnClickListener {

        var mPurchaseDate: TextView
        var mStatusCheckbox: CheckBox
        var mViewHolderClick: OnViewHolderClick

        constructor(itemView: View, purchaseDateId: Int, statusCheckboxId: Int, viewHolderClick: OnViewHolderClick) : super(itemView){
            mPurchaseDate = itemView.findViewById(purchaseDateId) as TextView
            mStatusCheckbox = itemView.findViewById(statusCheckboxId) as CheckBox
            mViewHolderClick = viewHolderClick
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            mViewHolderClick.onClick(v, adapterPosition)
        }
    }
}