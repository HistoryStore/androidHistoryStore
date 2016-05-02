package com.icaboalo.historystore.io

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by icaboalo on 28/04/16.
 */
class VendorApiModel {

    constructor(name: String, imageUrl: String, categories: ArrayList<CategoryApiModel>) {
        this.mName = name
        this.mImageUrl = imageUrl
        this.mCategories = categories
    }

    @SerializedName("id")
    var mId: String? = null

    @SerializedName("name")
    var mName: String

    @SerializedName("image")
    var mImageUrl: String

    @SerializedName("places")
    var mPlaces: ArrayList<PlaceApiModel>? = null

    @SerializedName("categories")
    var mCategories: ArrayList<CategoryApiModel>
}