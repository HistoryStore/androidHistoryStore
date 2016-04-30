package com.icaboalo.historystore.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.icaboalo.historystore.R
import com.icaboalo.historystore.io.PlaceApiModel
import com.squareup.picasso.Picasso
import java.util.*

/**
 * Created by icaboalo on 29/04/16.
 */
class CustomPlaceSpinnerAdapter : ArrayAdapter<PlaceApiModel> {

    var mContext: Context
    var mPlaceList: ArrayList<PlaceApiModel>
    var mResource: Int

    constructor(context: Context, resource: Int, placeList: ArrayList<PlaceApiModel>) : super(context, resource, placeList){
        this.mContext = context
        this.mPlaceList = placeList
        this.mResource = resource
    }

    override fun getDropDownView(position: Int, convertView: View, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    override fun getView(position: Int, convertView: View, parent: ViewGroup): View? {
        return getCustomView(position, convertView, parent)
    }


    fun getCustomView(position: Int, convertView: View, parent: ViewGroup): View{
        val inflater: LayoutInflater = LayoutInflater.from(mContext)
        val mySpinner: View = inflater.inflate(mResource, parent, false)
        val vendorText: TextView = mySpinner.findViewById(R.id.vendor_text) as TextView
        val addressText: TextView = mySpinner.findViewById(R.id.address_text) as TextView
        val vendorImage: ImageView = mySpinner.findViewById(R.id.vendor_image) as ImageView
        vendorText.text = mPlaceList[position].mVendor!!.mName
        addressText.text = mPlaceList[position].mAddress
        Picasso.with(mContext).load(mPlaceList[position].mVendor!!.mImageUrl).into(vendorImage)
        return mySpinner
    }



}