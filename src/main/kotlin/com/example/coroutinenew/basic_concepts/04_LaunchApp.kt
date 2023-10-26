package com.example.coroutinenew.basic_concepts

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    println("main function starts")
    printStudentCount()
    println("main function ends")
}

private suspend fun printStudentCount() {
    var students = 0
    val job = CoroutineScope(Dispatchers.IO).launch {
        students = getStudents()
    }
//    job.cancel()

    job.join()

    println("Number of students are $students")
}

private suspend fun getStudents() : Int {
    delay(1000)     // delay() is suspend function
    return 54
}