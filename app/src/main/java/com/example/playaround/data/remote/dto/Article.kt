package com.example.playaround.data.remote.dto

data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)

{
//    fun doesMatchSearchQuery(query:String):Boolean{
//        val matchingCombination = listOf(
//            "$firstName$lastName"
//
//        )
//        return matchingCombination.any{
//            it.contains(query, ignoreCase = true)
//        }
//    }
}