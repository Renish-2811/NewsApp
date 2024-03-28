package com.example.playaround.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.createSavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SubNewsViewModel @Inject constructor(saveSateHandle: SavedStateHandle):ViewModel() {

    private val _passedVar = mutableStateOf("Default Value")
    val passedVar: MutableState<String> = _passedVar
    init {
        _passedVar.value = saveSateHandle.get<String>("name").toString()
    }
    fun updateTextBox():String{
        return _passedVar.value
    }
}