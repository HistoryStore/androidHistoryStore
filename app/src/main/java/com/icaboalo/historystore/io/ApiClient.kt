package com.icaboalo.historystore.io

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by icaboalo on 28/04/16.
 */
class ApiClient{
    var mApiService: ApiService? = null

    fun getApiService(): ApiService {
        if (mApiService == null) {
            val nRetrofit = Retrofit.Builder()
                    .baseUrl("https://history-store.herokuapp.com/api/")
                    .addConverterFactory(GsonConverterFactory.create()).build()
            mApiService = nRetrofit.create(ApiService::class.java)
        }
        return mApiService!!
    }
}