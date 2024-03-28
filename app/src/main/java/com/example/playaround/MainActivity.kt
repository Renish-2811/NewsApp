package com.example.playaround

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.playaround.ui.theme.PlayAroundTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            PlayAroundTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.MainNewsScreen.route
                    ) {
                        composable(
                            route = Screen.MainNewsScreen.route
                        ) {
                            MainNewsScreen(modifier = Modifier, navController =navController)
                        }
                        composable(
                            route = Screen.SubNewsScreem.route + "/{name}",
                            arguments = listOf(
                                navArgument("name"){
                                    type = NavType.StringType
                                    defaultValue = "Phillip"
                                    nullable = true
                                }
                            )
                        ) {
                            SubNewsScreem()
                        }
                    }
                }

            }
        }
    }

}

