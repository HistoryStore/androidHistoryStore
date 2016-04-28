package com.icaboalo.historystore.io

import com.google.gson.annotations.SerializedName

/**
 * Created by icaboalo on 27/04/16.
 */
class ProductApiModel {

    constructor(name: String, typeUOM: String, conversion: String, categoryId: Int) {
        this.mName = name
        this.mTypeUOM = typeUOM
        this.mConversion = conversion
        this.mCategoryId = categoryId
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

    @SerializedName("category")
    var mCategory: CategoryApiModel? = null

    @SerializedName("category_id")
    var mCategoryId: Int
}