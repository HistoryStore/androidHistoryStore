package com.icaboalo.historystore.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.icaboalo.historystore.R

/**
 * Created by icaboalo on 1/05/16.
 */
class PlacesFragment: Fragment() {

    var mPlaceRecycler: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_places, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPlaceRecycler = view.findViewById(R.id.place_recycler) as RecyclerView?
    }


}