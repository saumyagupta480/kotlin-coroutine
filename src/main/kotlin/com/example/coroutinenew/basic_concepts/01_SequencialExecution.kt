package com.example.coroutinenew.basic_concepts

import kotlin.system.measureTimeMillis

fun main() {
    Thread.currentThread().name = "Main Thread"

    val timeTaken = measureTimeMillis {
        println("main starts on - ${Thread.currentThread().name}")

        printMessageA()
        printMessageB()
        printMessageC()

        println("main ends on - ${Thread.currentThread().name}")
    }
    println("total time taken : $timeTaken")
}

private fun printMessageA() {
    Thread.sleep(2000)
    println("Function A on - ${Thread.currentThread().name}")
}

private fun printMessageB() {
    Thread.sleep(2000)
    println("Function B on - ${Thread.currentThread().name}")
}

private fun printMessageC() {
    Thread.sleep(2000)
    println("Function C on - ${Thread.currentThread().name}")
}
