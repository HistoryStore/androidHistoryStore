package com.icaboalo.historystore.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.icaboalo.historystore.R
import com.icaboalo.historystore.io.PlaceApiModel
import com.squareup.picasso.Picasso
import java.util.*

/**
 * Created by icaboalo on 2/05/16.
 */
class PlaceRecyclerAdapter: RecyclerView.Adapter<PlaceRecyclerAdapter.PlaceViewHolder> {

    var mContext: Context
    var mPlaceList: ArrayList<PlaceApiModel>
    var mInflater: LayoutInflater
    var mViewHolderClick: OnViewHolderClick

    constructor(context: Context, placeList: ArrayList<PlaceApiModel>, viewHolderClick: OnViewHolderClick) : super(){
        this.mContext = context
        this.mPlaceList = placeList
        this.mInflater = LayoutInflater.from(context)
        this.mViewHolderClick = viewHolderClick
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PlaceViewHolder? {
        val view: View = mInflater.inflate(R.layout.item_places, parent, false)
        return PlaceViewHolder(view, R.id.vendor_image, R.id.distance_text, mViewHolderClick)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val place: PlaceApiModel = mPlaceList[position]
//        holder.setVendorImage(place.mVendor.mImageUrl)
        holder.mVendorDistance.text = "DISTANCE"
    }

    override fun getItemCount(): Int {
        return mPlaceList.size
    }

    inner class PlaceViewHolder: RecyclerView.ViewHolder, View.OnClickListener {
        var mVendorImage: ImageView
        var mVendorDistance: TextView
        var mViewHolderClick: OnViewHolderClick

        constructor(itemView: View, vendorImageId: Int, vendorDistanceId: Int, viewHolderClick: OnViewHolderClick) : super(itemView){
            mVendorImage = itemView.findViewById(vendorImageId) as ImageView
            mVendorDistance = itemView.findViewById(vendorDistanceId) as TextView
            mViewHolderClick = viewHolderClick
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            mViewHolderClick.onClick(v, adapterPosition)
        }

        fun setVendorImage(imageUrl: String){
            Picasso.with(mContext).load(imageUrl).into(mVendorImage)
        }
    }
}