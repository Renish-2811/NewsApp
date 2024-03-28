package com.example.playaround

sealed class Screen (val route:String) {
    object MainNewsScreen:Screen("main_screen")
    object SubNewsScreem:Screen("sub_screen")

}