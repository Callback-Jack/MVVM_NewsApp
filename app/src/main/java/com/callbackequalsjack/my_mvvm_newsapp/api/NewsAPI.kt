package com.callbackequalsjack.my_mvvm_newsapp.api

import com.callbackequalsjack.my_mvvm_newsapp.models.NewsResponse
import com.callbackequalsjack.my_mvvm_newsapp.util.Constants.Companion.API_KEY
import com.callbackequalsjack.my_mvvm_newsapp.util.Constants.Companion.COUNTRY_CODE
import com.callbackequalsjack.my_mvvm_newsapp.util.Constants.Companion.PAGE_SIZE
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = COUNTRY_CODE,
        @Query("page")
        pageNum: Int = 1,
        @Query("pageSize")
        pageSize: Int = PAGE_SIZE,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNum: Int = 1,
        @Query("pageSize")
        pageSize: Int = PAGE_SIZE,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>
}