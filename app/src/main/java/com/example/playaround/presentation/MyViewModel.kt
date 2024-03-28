package com.example.playaround.presentation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.playaround.Constant.Constant
import com.example.playaround.Constant.Resource
import com.example.playaround.domain.usecase.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class MyViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(NewsListState())
    val state: State<NewsListState> = _state
    private val _query = mutableStateOf("bitcoin")
    val query: MutableState<String> = _query


    init {
        getNews()
//        val a  = getNews()
//        val searchtext = _query.debounce(5000)
//            .combine(a){
//                c,d->
//
//
//            }
    }

    private fun getNews(){
        println("Query is: ${query.value}")
        getNewsUseCase("everything", query.value, Constant.key).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = NewsListState(news = result.data)
                    Log.d(this.toString(), result.data.toString())
                }
                is Resource.Error -> {
                    _state.value = NewsListState(error = result.message ?: "Unexpected")

                }

                is Resource.Loading -> {
                    _state.value = NewsListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }

    fun onqueryChange(query: String) {
        _query.value = query
        getNews()
    }
}


