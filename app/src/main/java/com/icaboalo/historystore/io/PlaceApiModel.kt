package com.icaboalo.historystore.io

import com.google.gson.annotations.SerializedName

/**
 * Created by icaboalo on 27/04/16.
 */
class PlaceApiModel {

    constructor(mAddress: String, mLatitude: String, mLongitude: String) {
        this.mAddress = mAddress
        this.mLatitude = mLatitude
        this.mLongitude = mLongitude
    }

    @SerializedName("id")
    var mId: Int? = null

    @SerializedName("address")
    var mAddress: String

    @SerializedName("latitude")
    var mLatitude: String

    @SerializedName("longitude")
    var mLongitude: String
}