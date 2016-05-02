package com.icaboalo.historystore.io

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by icaboalo on 27/04/16.
 */
class UserApiModel: Serializable {

    constructor(mUserName: String, mFirstName: String, mLastName: String, mEmail: String) {
        this.mUserName = mUserName
        this.mFirstName = mFirstName
        this.mLastName = mLastName
        this.mEmail = mEmail
    }

    @SerializedName("id")
    var mId: Int? = null

    @SerializedName("username")
    var mUserName: String

    @SerializedName("first_name")
    var mFirstName: String

    @SerializedName("last_name")
    var mLastName: String

    @SerializedName("email")
    var mEmail: String
}