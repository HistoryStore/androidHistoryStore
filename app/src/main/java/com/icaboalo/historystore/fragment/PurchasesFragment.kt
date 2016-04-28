package com.icaboalo.historystore.fragment

import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.Bind
import butterknife.ButterKnife
import com.icaboalo.historystore.R
import java.util.*

/**
 * Created by icaboalo on 27/04/16.
 */
class PurchasesFragment: Fragment() {

    @Bind(R.id.purchase_recycler)
    var mPurchaseRecycler: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_purchases, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(this, view)
    }

    fun setupPurchaseRecycler(purchasesList: ArrayList<String>) {

    }
}