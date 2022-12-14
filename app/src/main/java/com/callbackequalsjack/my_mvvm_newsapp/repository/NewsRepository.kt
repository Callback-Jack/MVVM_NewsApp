package com.callbackequalsjack.my_mvvm_newsapp.repository

import com.callbackequalsjack.my_mvvm_newsapp.api.RetrofitInstance
import com.callbackequalsjack.my_mvvm_newsapp.db.ArticleDatabase
import com.callbackequalsjack.my_mvvm_newsapp.models.Article

class NewsRepository(
    private val db: ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode: String, pageNum: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNum)

    suspend fun searchNews(searchQuery: String, pageNum: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNum)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}