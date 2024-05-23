package com.example.coroutinenew.controller

import com.example.coroutinenew.service.ApiService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ApiController(private val apiService: ApiService) {

    @GetMapping("/news")
    fun fetchData(): ResponseEntity<Any?> = ResponseEntity.ok(
        apiService.getNewsArticles()
    )

    @GetMapping("/health")
    fun sayHello(): String {
        return "Up"
    }

    @GetMapping("/monitor")
    fun checkUp(): String {
        return "Success"
    }
}