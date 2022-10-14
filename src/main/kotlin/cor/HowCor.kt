package cor

import kotlin.coroutines.*

fun main() {
//    createAndStartCor()
    receiverCor()
}


fun createAndStartCor() {
    /**
     * 创建协程
     */
    val cor = suspend { 3 }.createCoroutine(object : Continuation<Int> {
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<Int>) {
            println("${result.isSuccess} ${result.getOrNull()}")
        }
    })

    /**
     * 启动协程
     */
    cor.resume(Unit)
//    cor.resumeWith(Result.success(Unit))
//    cor.resumeWithException(Exception("unKnownError"))


    /**
     * 创建并启动协程
     */
    suspend { 4 }.startCoroutine(object : Continuation<Int> {
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<Int>) {
            println("${result.isSuccess} ${result.getOrNull()}")
        }
    })

    suspend { 6 }.startCoroutine(Continuation(EmptyCoroutineContext) {
        println(it.getOrNull())
    })

}

fun receiverCor() {
    val produce = ProducerScope<Int>()
    launchCoroutine(produce) {
        produce(2)
        4
    }

}


fun <R, T> launchCoroutine(receiver: R, block: suspend R.() -> T) {

    block.startCoroutine(receiver, object : Continuation<T> {
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<T>) {
            println("coroutine end ${result.getOrNull()}")
        }
    })
}

class ProducerScope<T> {
    suspend fun produce(value: T): T {
        println("produce value now: $value")
        return value
    }

}

