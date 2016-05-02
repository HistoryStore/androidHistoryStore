package com.icaboalo.historystore.io

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

/**
 * Created by icaboalo on 28/04/16.
 */
class CategoryApiModel: Serializable {

    constructor(name: String) {
        this.mName = name
    }

    @SerializedName("id")
    var mId: Int? = null

    @SerializedName("name")
    var mName: String

    @SerializedName("products")
    var mProducts: ArrayList<ProductApiModel>? = null

    override fun toString(): String {
        return mName
    }
}