package com.example.coroutinenew.basic_concepts

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

suspend fun main() {

    val deferred: Deferred<Unit> = CoroutineScope(Dispatchers.IO).async {
        printTeachersCount()
    }
    deferred.await()

    println("Main program ends")
}

suspend fun printTeachersCount() {
    val deferred: Deferred<String> = CoroutineScope(Dispatchers.IO).async {
        getTeachers()
        "10"   // explain return type of coroutine
    }
    deferred.await()

    println("Number of teachers are ${deferred.await()}")
}

suspend fun getTeachers() : Int {
    delay(1000)     // delay() is suspend function
    return 54
}