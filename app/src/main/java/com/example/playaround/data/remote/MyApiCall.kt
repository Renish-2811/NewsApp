package com.example.playaround.data.remote

import androidx.compose.runtime.State
import com.example.playaround.data.remote.dto.News
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MyApiCall {

    @GET("/v2/{pathParam}")
    suspend fun getCoins(@Path("pathParam") pathId: String, @Query("q") sources: String, @Query("apiKey") key:String):News

}