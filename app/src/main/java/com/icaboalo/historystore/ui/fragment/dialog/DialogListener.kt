package com.icaboalo.historystore.ui.fragment.dialog

import android.content.DialogInterface
import android.support.v4.app.DialogFragment
import com.icaboalo.historystore.PurchaseApiModel

/**
 * Created by icaboalo on 29/04/16.
 */
interface DialogListener {
    fun onDialogPositiveClick(dialog: DialogInterface, TAG: String)
    fun onDialogNeutralClick(dialog: DialogInterface, TAG: String, model: Any?)
    fun onDialogNegativeClick(dialog: DialogInterface, TAG: String)
}