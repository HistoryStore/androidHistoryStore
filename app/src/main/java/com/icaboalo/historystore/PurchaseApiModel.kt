package com.icaboalo.historystore

import com.google.gson.annotations.SerializedName
import com.icaboalo.historystore.io.PlaceApiModel
import com.icaboalo.historystore.io.ProductApiModel
import com.icaboalo.historystore.io.UserApiModel
import java.util.*

/**
 * Created by icaboalo on 27/04/16.
 */
class PurchaseApiModel{

    constructor(mPurchaseDate: String, mStatus: Boolean, mUserId: Int, mPlaceId: Int, mProducts: ArrayList<ProductApiModel>) {
        this.mPurchaseDate = mPurchaseDate
        this.mStatus = mStatus
        this.mUserId = mUserId
        this.mPlaceId = mPlaceId
        this.mProducts = mProducts
    }

    @SerializedName("id")
    var mId: String? = null

    @SerializedName("date_shopping")
    var mPurchaseDate: String

    @SerializedName("status")
    var mStatus: Boolean

    @SerializedName("user")
    var mUser: UserApiModel? = null

    @SerializedName("user_id")
    var mUserId: Int

    @SerializedName("place_id")
    var mPlaceId: Int

    @SerializedName("place")
    var mPlace: PlaceApiModel? = null

    @SerializedName("products")
    var mProducts: ArrayList<ProductApiModel>
}