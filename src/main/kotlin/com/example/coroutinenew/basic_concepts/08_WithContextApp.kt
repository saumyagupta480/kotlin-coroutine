package com.example.coroutinenew.basic_concepts

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// problem statement
/* fun main() {
    println("start")
    GlobalScope.launch {
        delay(1000)
        println("middle")
    }
    println("end")
}*/

// handling with withContext
suspend fun main() {
    println("start")
    withContext(context = Dispatchers.IO) {
        delay(1000)
        println("middle")
    }
    println("end")
}
