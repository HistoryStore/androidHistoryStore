package com.icaboalo.historystore.io

import com.icaboalo.historystore.PurchaseApiModel
import retrofit2.http.GET
import retrofit2.Call
import java.util.*

/**
 * Created by icaboalo on 28/04/16.
 */
interface ApiService {

    @GET("lists/")
    fun getPurchaseList(): Call<ArrayList<PurchaseApiModel>>

    @GET("vendors/")
    fun getVendorList():Call<ArrayList<VendorApiModel>>

    @GET("places/")
    fun getPlaceList(): Call<ArrayList<PlaceApiModel>>

    @GET("products/")
    fun getProductList(): Call<ArrayList<ProductApiModel>>
}

