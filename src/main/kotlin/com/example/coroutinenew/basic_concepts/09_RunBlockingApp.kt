package com.example.coroutinenew.basic_concepts

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// problem statement
 /*fun main() {
    GlobalScope.launch {
        delay(2000)
        println("World!!")
    }
    println("Hello")
}*/

// handling with thread
/* fun main() {
    GlobalScope.launch {
        delay(2000)
        println("World!!")
    }
    println("Hello")
    Thread.sleep(2500)
}*/

// handling using runBlocking
 fun main() {
    runBlocking {
        launch {
            delay(2000)
            println("World!!")
        }
        println("Hello")
    }
}

// refactoring
/*fun main() = runBlocking {
    launch {
        delay(2000)
        println("World!!")
    }
    println("Hello")
}*/
