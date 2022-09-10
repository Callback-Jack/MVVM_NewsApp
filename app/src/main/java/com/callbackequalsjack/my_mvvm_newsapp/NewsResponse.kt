package com.callbackequalsjack.my_mvvm_newsapp

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)