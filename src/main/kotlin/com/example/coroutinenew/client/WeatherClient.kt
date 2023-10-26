package com.example.coroutinenew.client

import kotlinx.coroutines.delay
import org.springframework.stereotype.Service

@Service
class WeatherClient() {

    suspend fun getWeatherResponse(): Map<String, String> {
        val weatherMap = mutableMapOf<String, String>()
        weatherMap["Delhi"] = "30"
        weatherMap["Mumbai"] = "25"
        weatherMap["Hydrabad"] = "27"
        weatherMap["Kolkata"] = "32"

        delay(1000)
        return weatherMap
    }

}