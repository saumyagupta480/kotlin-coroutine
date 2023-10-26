package com.example.coroutinenew

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CoroutineNewsApplication

fun main(args: Array<String>) {
	runApplication<CoroutineNewsApplication>(*args)
}
