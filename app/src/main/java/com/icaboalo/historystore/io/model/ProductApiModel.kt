package com.icaboalo.historystore.io

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by icaboalo on 27/04/16.
 */
class ProductApiModel: Serializable {

    constructor(name: String, typeUOM: String, conversion: String, price:String, categoryId: Int, imageUrl: String) {
        this.mName = name
        this.mTypeUOM = typeUOM
        this.mConversion = conversion
        this.mPrice = price
        this.mCategoryId = categoryId
        this.mImageUrl = imageUrl
    }


    @SerializedName("id")
    var mId: Int? = null

    @SerializedName("code")
    var mCode: String? = null

    @SerializedName("name")
    var mName: String

    @SerializedName("image")
    var mImageUrl: String

    @SerializedName("type_uom")
    var mTypeUOM: String

    @SerializedName("conversion")
    var mConversion: String

    @SerializedName("price")
    var mPrice: String

    @SerializedName("category")
    var mCategory: CategoryApiModel? = null

    @SerializedName("category_id")
    var mCategoryId: Int

    override fun toString(): String {
        return mName
    }
}