package cor.jet

import kotlinx.coroutines.*

suspend fun main() {

    println("start: ${Thread.currentThread().name}")
    coroutineScope {
        doSomething()
    }

    println("end: ${Thread.currentThread().name}")

}

@OptIn(DelicateCoroutinesApi::class)
suspend fun doSomething() = coroutineScope {
    val job = launch {
        delay(1000)
        println("world: ${Thread.currentThread().name}")
    }

    println("hello: ${Thread.currentThread().name}")
    job.join()

    async(newSingleThreadContext("myThread")) {
        println("async: ${Thread.currentThread().name}")
    }
}
