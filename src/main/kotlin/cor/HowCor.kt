package cor

import kotlin.coroutines.*

fun main() {
    createCor()
}

fun createCor() {
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


}


