package com.example.coroutinenew.basic_concepts

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch(Dispatchers.Default) {
            println("Starting threadTask on ${Thread.currentThread().name}")
            threadTask()
            println("Ending threadTask on ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Default) {
            println("Starting coroutineTask on ${Thread.currentThread().name}")
            coroutineTask()
            println("Ending coroutineTask on ${Thread.currentThread().name}")
        }
    }
}

fun threadTask() {
    Thread.sleep(4000)
}

suspend fun coroutineTask() {    // suspending function
    delay(4000)    // used to define suspension point
}
