package com.example.coroutinenew.service

import com.example.coroutinenew.client.ArticleClient
import com.example.coroutinenew.client.WeatherClient
import com.example.coroutinenew.dto.Article
import com.example.coroutinenew.dto.NewsResponse
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service

@Service
class ApiService(private val articleClient: ArticleClient, private val weatherClient: WeatherClient) {

    fun getNewsArticles(): NewsResponse? {
        var articles: List<Article>? = null
        var weather: Map<String, String>? = null
        runBlocking {
            val articleJob = async { articleClient.getArticleResponse() }
            val weatherJob = async { weatherClient.getWeatherResponse() }

            articles = articleJob.await()?.articles
            weather = weatherJob.await()
        }
        return NewsResponse(weather = weather, articles = articles)
    }

}