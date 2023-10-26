package com.example.coroutinenew.basic_concepts

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    println("Parent job started")

    val parentJob = CoroutineScope(Dispatchers.Default).launch {

        val childJob = launch {
            println("Child job started")
            delay(2000)
            println("Child job ended")
        }
        delay(1000)
        childJob.cancel()
        println("Child job cancelled")
    }
    parentJob.join()

    println("Parent job ended")
}

// UseCase - User click on back button while data being fetched
