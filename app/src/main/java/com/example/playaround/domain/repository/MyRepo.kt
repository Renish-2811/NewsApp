package com.example.playaround.domain.repository

import androidx.compose.runtime.State
import com.example.playaround.data.remote.dto.News

interface MyRepo {
    suspend fun doNetworkCall(pathaParam: String, queryParam: String, key:String):News
}