package com.icaboalo.historystore

import com.google.gson.annotations.SerializedName
import com.icaboalo.historystore.io.PlaceApiModel
import com.icaboalo.historystore.io.ProductApiModel
import com.icaboalo.historystore.io.UserApiModel
import java.io.Serializable
import java.util.*

/**
 * Created by icaboalo on 27/04/16.
 */
class PurchaseApiModel: Serializable{

    constructor(mPurchaseDate: String, mStatus: Boolean, mUser: UserApiModel, mPlace: PlaceApiModel, mProducts: ArrayList<ProductApiModel>) {
        this.mPurchaseDate = mPurchaseDate
        this.mStatus = mStatus
        this.mUser = mUser
        this.mPlace = mPlace
        this.mProducts = mProducts
    }

    @SerializedName("id")
    var mId: Int? = null

    @SerializedName("date_shopping")
    var mPurchaseDate: String

    @SerializedName("status")
    var mStatus: Boolean

    @SerializedName("user")
    var mUser: UserApiModel? = null

    @SerializedName("place")
    var mPlace: PlaceApiModel? = null

    @SerializedName("products")
    var mProducts: ArrayList<ProductApiModel>
}