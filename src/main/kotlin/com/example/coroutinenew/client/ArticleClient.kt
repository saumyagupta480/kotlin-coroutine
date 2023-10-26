package com.example.coroutinenew.client

import com.example.coroutinenew.dto.ArticleResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Service
class ArticleClient(private val restTemplate: RestTemplate) {

    suspend fun getArticleResponse(): ArticleResponse? {
        val hostUrl = "https://newsapi.org/v2"
        val baseUri = "/top-headlines"
        val queryParamMap = LinkedMultiValueMap<String, String>()
        queryParamMap.add("apiKey", "e3ae11a7be294f689cd35aeaac650fae")
        queryParamMap.add("country", "in")
        queryParamMap.add("page", "1")
        queryParamMap.add("pageSize", "10")
        val url = UriComponentsBuilder.fromHttpUrl(hostUrl).path(baseUri).queryParams(queryParamMap)
            .build().toUriString()

        val response = withContext(Dispatchers.IO) {
            restTemplate.getForObject(url, ArticleResponse::class.java)
        }
        delay(1500)
        return response
    }

}