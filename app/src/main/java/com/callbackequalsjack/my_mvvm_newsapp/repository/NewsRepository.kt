package com.callbackequalsjack.my_mvvm_newsapp.repository

import com.callbackequalsjack.my_mvvm_newsapp.api.RetrofitInstance
import com.callbackequalsjack.my_mvvm_newsapp.db.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode: String, pageNum: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNum)
}