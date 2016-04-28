package com.icaboalo.historystore.io

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by icaboalo on 28/04/16.
 */
class CategoryApiModel {

    constructor(name: String, image: String) {
        this.mName = name
        this.mImageUrl = image
    }

    @SerializedName("id")
    var mId: Int? = null

    @SerializedName("name")
    var mName: String

    @SerializedName("image")
    var mImageUrl: String

    @SerializedName("products")
    var mProducts: ArrayList<ProductApiModel>? = null
}