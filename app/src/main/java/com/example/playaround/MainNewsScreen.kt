package com.example.playaround

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.playaround.presentation.MyViewModel


@Composable
fun MainNewsScreen(viewModel: MyViewModel = hiltViewModel(), modifier: Modifier, navController: NavController){

    Box(modifier  = Modifier.fillMaxSize() , contentAlignment = Alignment.Center){
        if (viewModel.state.value.isLoading){
            CircularProgressIndicator()
        }
        else if (viewModel.state.value.error.isNotBlank()){
            Text("Some error occured")
        }
        else{
            LazyColumn(modifier = Modifier.fillMaxSize()){
                viewModel.state.value.news?.let {
                    items(it.articles){
                            articles ->
                        AsyncImage(
                            model = articles.urlToImage,
                            placeholder = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "",
                            contentScale = ContentScale.Inside,
                            modifier = Modifier.clickable {
                                navController.navigate(Screen.SubNewsScreem.route + "/${articles.author}")
                            }
                        )
                        Text(text = "Articles is: ${articles.author}")
                        Text(text = "Articles is: ${articles.content}")
                        Divider()
                        Spacer(modifier = Modifier.fillMaxSize())
                    }
                }

            }
        }

    }
}
