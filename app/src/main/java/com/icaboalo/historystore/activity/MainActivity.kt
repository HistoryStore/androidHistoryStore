package com.icaboalo.historystore.activity

import android.content.DialogInterface
import android.content.Intent
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Toast

import butterknife.Bind
import butterknife.ButterKnife
import com.icaboalo.historystore.PurchaseApiModel
import com.icaboalo.historystore.R
import com.icaboalo.historystore.fragment.PurchasesFragment
import com.icaboalo.historystore.fragment.dialog.DialogListener
import com.icaboalo.historystore.fragment.dialog.PurchaseDetailDialog

class MainActivity : AppCompatActivity(), DialogListener {

    @Bind(R.id.navigation_view)
    internal var mNavigationView: NavigationView? = null

    @Bind(R.id.drawer_layout)
    internal var mDrawerLayout: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nToolbar = findViewById(R.id.app_bar) as Toolbar?
        setSupportActionBar(nToolbar)
        ButterKnife.bind(this)
//        navigationViewOnClick()
        replaceFragment(PurchasesFragment())
    }

    internal fun navigationViewOnClick() {
        mNavigationView!!.setNavigationItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.action_capture_list -> {
                    fragment = PurchasesFragment()
                }
            }
            replaceFragment(fragment!!)
            mDrawerLayout!!.closeDrawers()
            false
        }
    }

    override fun onDialogPositiveClick(dialog: DialogInterface, TAG: String) {
        throw UnsupportedOperationException()
    }

    override fun onDialogNeutralClick(dialog: DialogInterface, TAG: String, model: Any?) {
        if (TAG.equals("PURCHASE_DETAIL_DIALOG")){
            Toast.makeText(this@MainActivity, "SUCCESS", Toast.LENGTH_SHORT).show()
            val editPurchase: Intent = Intent(this@MainActivity, EditPurchaseActivity::class.java)
            val purchaseModel: PurchaseApiModel = model as PurchaseApiModel
            editPurchase.putExtra("MODEL", purchaseModel)
            startActivity(editPurchase)
        }

    }

    override fun onDialogNegativeClick(dialog: DialogInterface, TAG: String) {
        throw UnsupportedOperationException()
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}
