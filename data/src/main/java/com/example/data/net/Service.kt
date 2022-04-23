package com.example.data.net

import com.example.data.storage.cloudModel.DataCloud
import retrofit2.http.GET

interface Service {

    companion object {
        const val BASE_URL = "https://run.mocky.io/"
    }

    @GET("v3/654bd15e-b121-49ba-a588-960956b15175")
    suspend fun fetchCloud(): DataCloud
}

