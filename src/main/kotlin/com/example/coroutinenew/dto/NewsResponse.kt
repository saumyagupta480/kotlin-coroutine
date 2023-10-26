package com.example.coroutinenew.dto

data class NewsResponse(

    val weather: Map<String,String>? = null,
    val articles: List<Article>? = null
)