package com.icaboalo.historystore.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.icaboalo.historystore.PurchaseApiModel

import com.icaboalo.historystore.R

class EditPurchaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_purchase)
        val purchase: PurchaseApiModel = intent.extras.getSerializable("MODEL") as PurchaseApiModel
        Toast.makeText(this@EditPurchaseActivity, purchase.mPurchaseDate, Toast.LENGTH_SHORT).show()
    }
}
