package com.example.playaround.data.repository

import androidx.compose.runtime.State
import com.example.playaround.data.remote.MyApiCall
import com.example.playaround.data.remote.dto.News
import com.example.playaround.domain.repository.MyRepo
import javax.inject.Inject

class MyRepoImpl @Inject constructor(
    private val api: MyApiCall
):MyRepo

{
    override suspend fun doNetworkCall(pathaParam: String, queryParam: String, key:String):News {
              return  api.getCoins(pathaParam,queryParam,key)
    }
}