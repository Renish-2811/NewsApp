package com.example.playaround

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.playaround.presentation.SubNewsViewModel

@Composable
fun SubNewsScreem(
    subNewsViewModel: SubNewsViewModel = hiltViewModel()
) {
    Box(modifier = Modifier.fillMaxSize()) {
            Text("Here is the data from screen1:${subNewsViewModel.updateTextBox()}")
    }
}