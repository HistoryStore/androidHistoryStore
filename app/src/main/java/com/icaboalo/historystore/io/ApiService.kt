package com.icaboalo.historystore.io

import com.icaboalo.historystore.PurchaseApiModel
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.PUT
import retrofit2.http.Path
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

    @GET("categories/")
    fun getCategoryList(): Call<ArrayList<CategoryApiModel>>

    @PUT("lists/{id}/")
    fun putPurchase(@Path("id") purchaseId: String, @Body purchase: PurchaseApiModel): Call<PurchaseApiModel>
}

