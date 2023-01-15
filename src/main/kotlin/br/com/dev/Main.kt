package br.com.dev

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        val hello = getHello()
        val world = getWorld()
        println("$hello $world")
    }

    val timeAsync = measureTimeMillis {
        runBlocking {
            val helloAsync = async { getHelloAsync() }
            val worldAsync = async { getWorldAsync() }
            println("${helloAsync.await()} ${worldAsync.await()}")
        }
    }

    println("Blocking: $time")
    println("Async: $timeAsync")
}

fun getHello(): String {
    Thread.sleep(5000)
    return "Hello"
}

fun getWorld(): String {
    Thread.sleep(5000)
    return "World"
}

suspend fun getHelloAsync(): String {
    delay(5000)
    return "Hello"
}

suspend fun getWorldAsync(): String {
    delay(5000)
    return "World"
}