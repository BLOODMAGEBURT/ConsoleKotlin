package cor.pro

import cor.launchCoroutine
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun main() {

    suspend {
        println("2 ${Thread.currentThread().name}")
        delay(3000L)
        println("3 ${Thread.currentThread().name}")

    }.invoke()

    println("4 ${Thread.currentThread().name}")


}

/**
 * 简易版 delay()函数
 * 1.   不阻塞线程
 * 2.   suspend,特定时间后恢复执行
 */

suspend fun delay(time: Long, unit: TimeUnit = TimeUnit.MILLISECONDS) {
    if (time <= 0) return

    val executor = Executors.newSingleThreadScheduledExecutor {
        Thread(it, "Scheduler").apply { isDaemon = true }
    }

    suspendCoroutine<Unit> {
        executor.schedule({ it.resume(Unit) }, time, unit)
    }

}