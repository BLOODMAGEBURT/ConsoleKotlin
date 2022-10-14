package cor.job

import cor.core.Disposable
import cor.core.OnCancel
import cor.core.OnComplete
import cor.job.launch
import kotlinx.coroutines.*
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.startCoroutine

interface Job : CoroutineContext.Element {

    companion object Key : CoroutineContext.Key<Job>

    override val key: CoroutineContext.Key<*>
        get() = Key

    val isActive: Boolean

    fun cancel()
    fun join()

    fun invokeOnCancel(onCancel: OnCancel): Disposable
    fun invokeOnCompletion(onComplete: OnComplete): Disposable
    fun remove(disposable: Disposable)

}


fun launch(
    context: CoroutineContext = EmptyCoroutineContext,
    block: suspend () -> Unit
): Job {
    val completion = StandaloneCoroutine(context)
    block.startCoroutine(completion)
    return completion
}


fun main() {
    println("start ${Runtime.getRuntime().availableProcessors()}")

    runBlocking {
        test2()
    }

    println("end")

}

suspend fun test2() {

    val seq = sequence {
        yield(1L)
        var next = 1L
        var current = 1L
        while (true) {
            yield(next)
            next += current
            current = next - current
        }
    }

    seq.take(10).forEach(::println)

}

fun test1() {

    runBlocking {
        val count = async(Dispatchers.Default) {
            println("fetching from thread ${Thread.currentThread()}")
            Runtime.getRuntime().availableProcessors()
        }

        println("call from thread ${Thread.currentThread()}")
        println("num of cores ${count.await()}")

    }


}

private fun test() {
    Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()).asCoroutineDispatcher().use {

        runBlocking(CoroutineName("top")) {

            // 并没有启动新协程
            withContext(Dispatchers.IO) {
                task1()
            }
            // 启动新协程
            launch(Dispatchers.Default) {
                task2()
            }

            println("call from thread ${Thread.currentThread()}")
        }
    }
}


suspend fun task1() {
    println("task1 start in thread ${Thread.currentThread()}")
    delay(300)
    println("task1 end in thread ${Thread.currentThread()}")
}

suspend fun task2() {
    println("task2 start in thread ${Thread.currentThread()}")
    yield()
    println("task2 end in thread ${Thread.currentThread()}")
}


