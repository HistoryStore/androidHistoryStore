package com.icaboalo.historystore.fragment.dialog

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import com.icaboalo.historystore.R
import com.icaboalo.historystore.io.ProductApiModel
import java.util.*

/**
 * Created by icaboalo on 28/04/16.
 */
class PurchaseDetailDialog: DialogFragment() {

    fun newInstance(token: String, purchaseId: Int, list: ArrayList<ProductApiModel>): PurchaseDetailDialog{
        val fragment = PurchaseDetailDialog()
        val args = Bundle()
        args.putString("TOKEN", token)
        args.putInt("PURCHASE_ID", purchaseId)
//        args.putParcelableArrayList("LIST", list)
        fragment.arguments = args
        return fragment
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(activity)
        val inflater = activity.layoutInflater
        val view = inflater.inflate(R.layout.dialog_detail_purchase, null)
        alertDialog.setView(view)
        alertDialog.setTitle("${getPurchaseId()}")
        return alertDialog.create()
    }

    fun getPurchaseId(): Int{
        return arguments.getInt("PURCHASE_ID")
    }
}