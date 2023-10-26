package com.example.coroutinenew.basic_concepts

import kotlin.system.measureTimeMillis
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    Thread.currentThread().name = "Main Thread"

    val timeTaken = measureTimeMillis {
        println("main starts on - ${Thread.currentThread().name}")

        val parentJob = CoroutineScope(Dispatchers.Default).launch {
            launch { printMessageA() }
            launch { printMessageB() }
            launch { printMessageC() }
        }
//        parentJob.join()
        parentJob.cancel()

        println("main ends on - ${Thread.currentThread().name}")
    }
    println("total time taken : $timeTaken")
}

private suspend fun printMessageA() {
    delay(2000)
    println("Function A on - ${Thread.currentThread().name}")
}
private suspend fun printMessageB() {
    delay(2000)
    println("Function B on - ${Thread.currentThread().name}")
}
private suspend fun printMessageC() {
    delay(2000)
    println("Function C on - ${Thread.currentThread().name}")
}
