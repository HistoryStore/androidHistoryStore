package com.icaboalo.historystore.io

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by icaboalo on 27/04/16.
 */
class PlaceApiModel: Serializable {

    constructor(address: String, latitude: String, longitude: String, vendor: VendorApiModel) {
        this.mAddress = address
        this.mLatitude = latitude
        this.mLongitude = longitude
        this.mVendor = vendor
    }

    @SerializedName("id")
    var mId: Int? = null

    @SerializedName("address")
    var mAddress: String

    @SerializedName("latitude")
    var mLatitude: String

    @SerializedName("longitude")
    var mLongitude: String

    @SerializedName("vendor")
    var mVendor: VendorApiModel
}