package com.icaboalo.historystore.fragment.dialog

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.util.Log
import com.icaboalo.historystore.PurchaseApiModel
import com.icaboalo.historystore.R
import com.icaboalo.historystore.io.ProductApiModel
import java.util.*

/**
 * Created by icaboalo on 28/04/16.
 */
class PurchaseDetailDialog: DialogFragment() {

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
        val view = inflater.inflate(R.layout.dialog_detail_purchase, null)
        alertDialog.setView(view)
        alertDialog.setTitle("${getPurchase().mPurchaseDate}")
        return alertDialog.create()
    }

    fun getPurchase(): PurchaseApiModel{
        return arguments.getSerializable("PURCHASE") as PurchaseApiModel
    }
}