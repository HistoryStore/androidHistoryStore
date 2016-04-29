package com.icaboalo.historystore.fragment.dialog

import android.content.DialogInterface
import android.support.v4.app.DialogFragment

/**
 * Created by icaboalo on 29/04/16.
 */
interface DialogListener {
    fun onDialogPositiveClick(dialog: DialogInterface, TAG: String)
    fun onDialogNeutralClick(dialog: DialogInterface, TAG: String)
    fun onDialogNegativeClick(dialog: DialogInterface, TAG: String)
}