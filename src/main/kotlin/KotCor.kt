import java.util.concurrent.Callable
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.Future
import kotlin.concurrent.thread

fun main() {

    val task = { println("B") }

    println("A")
    thread { task.invoke() }
    println("C")

    println(listOf(1, 2, 3, 5, 1, 4, 3,4).getDuplicates())


}

fun getAllBitmap(urls: List<String>): List<String> {

    val maps = mutableListOf<String>()

    urls.map {
        bitmapCompletableFuture(it)
    }.let { futureList ->
        CompletableFuture.allOf(*futureList.toTypedArray())
            .thenApply {
                futureList.map { it.get() }
            }
    }.thenAccept { bitmaps ->
        // 处理
        maps.addAll(bitmaps)
    }

    return maps
}


/**
 * Future方式创建异步任务
 */
fun bitmapFuture(url: String): Future<String> {

    return Executors.newFixedThreadPool(2).submit(Callable { url })

}

fun bitmapCompletableFuture(url: String): CompletableFuture<String> {

    return CompletableFuture.supplyAsync { url }
}

fun <T> List<T>.getDuplicates(): Set<T> {
    return groupingBy { it }.eachCount().filterValues { it > 1 }.keys
}
