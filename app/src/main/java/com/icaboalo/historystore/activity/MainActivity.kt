package com.icaboalo.historystore.activity

import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.MenuItem

import butterknife.Bind
import butterknife.ButterKnife
import com.icaboalo.historystore.R

class MainActivity : AppCompatActivity() {

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
        navigationViewOnClick()
    }

    internal fun navigationViewOnClick() {
        replaceFragment(Fragment())
        mNavigationView!!.setNavigationItemSelectedListener { item ->
            val fragment: Fragment? = null
            when (item.itemId) {
                R.id.action_capture_list -> {
                }
            }
            mDrawerLayout!!.closeDrawers()
            false
        }
    }

    internal fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}
