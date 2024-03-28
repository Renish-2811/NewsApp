package com.example.playaround.presentation

import com.example.playaround.data.remote.dto.News

class NewsListState(
    val isLoading:Boolean = false,
    val news: News? = null,
    val error: String = ""
)