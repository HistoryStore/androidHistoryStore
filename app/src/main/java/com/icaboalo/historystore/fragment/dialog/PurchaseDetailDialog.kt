package com.icaboalo.historystore.fragment.dialog

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.TextView
import com.icaboalo.historystore.PurchaseApiModel
import com.icaboalo.historystore.R.id.*
import com.icaboalo.historystore.R.layout.dialog_detail_purchase
import com.icaboalo.historystore.adapter.ProductRecyclerAdapter
import com.icaboalo.historystore.io.ProductApiModel
import java.util.*

/**
 * Created by icaboalo on 28/04/16.
 */
class PurchaseDetailDialog: DialogFragment() {

    var mProductRecycler: RecyclerView? = null
    var mVendorText: TextView? = null
    var mAddressText: TextView? = null
    var mTotalText: TextView? = null

    fun newInstance(purchase: PurchaseApiModel): PurchaseDetailDialog{
        val fragment = PurchaseDetailDialog()
        val args = Bundle()
        args.putSerializable("PURCHASE", purchase)
        fragment.arguments = args
        return fragment
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(activity)
        val inflater = activity.layoutInflater
        val view = inflater.inflate(dialog_detail_purchase, null)
        alertDialog.setView(view)
        alertDialog.setTitle(getPurchase().mPurchaseDate)
        setupProductRecycler(view, getPurchase().mProducts)
        setTexts(view)
        return alertDialog.create()
    }

    fun setTexts(view: View){
        mVendorText = view.findViewById(vendor_text) as TextView
        mAddressText = view.findViewById(address_text) as TextView
        mTotalText = view.findViewById(total_text) as TextView

        mVendorText!!.text = ""
        mAddressText!!.text = getPurchase().mPlace!!.mAddress
        mTotalText!!.text = "0"
    }

    fun getPurchase(): PurchaseApiModel{
        return arguments.getSerializable("PURCHASE") as PurchaseApiModel
    }

    fun setupProductRecycler(view: View, productList: ArrayList<ProductApiModel>){
        mProductRecycler = view.findViewById(product_recycler) as RecyclerView
        val productRecyclerAdapter: ProductRecyclerAdapter = ProductRecyclerAdapter(activity, productList)
        val linearLayout: LinearLayoutManager = LinearLayoutManager(activity)
        mProductRecycler!!.adapter = productRecyclerAdapter
        mProductRecycler!!.layoutManager = linearLayout

    }
}