package cor

import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    println("start")
    repeat(10) {
        println(test2())
    }
    println("end")
}


suspend fun test1(): Int {
    return 3
}

/**
 * 异步时 挂起
 */
suspend fun test2(): Int {
    return suspendCoroutine {
        thread {
            it.resume(5)
        }
    }
}

/**
 * 同步时 挂起函数不起作用
 */
suspend fun test3(): Int {
    return suspendCoroutine {
        it.resume(6)
    }
}