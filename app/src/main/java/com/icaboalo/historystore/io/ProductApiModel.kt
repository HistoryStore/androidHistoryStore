package com.icaboalo.historystore.io

import com.google.gson.annotations.SerializedName

/**
 * Created by icaboalo on 27/04/16.
 */
class ProductApiModel {

    constructor(mName: String, mTypeUOM: String, mConversion: String) {
        this.mName = mName
        this.mTypeUOM = mTypeUOM
        this.mConversion = mConversion
    }

    @SerializedName("id")
    var mId: Int? = null

    @SerializedName("code")
    var mCode: String? = null

    @SerializedName("name")
    var mName: String

    @SerializedName("type_uom")
    var mTypeUOM: String

    @SerializedName("conversion")
    var mConversion: String
}