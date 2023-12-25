package cor.pro

import java.util.concurrent.Callable
import kotlin.coroutines.*

fun main() {

}

interface AsyncScope

//fun async(
//    coroutineContext: CoroutineContext = EmptyCoroutineContext,
//    block: suspend AsyncScope.() -> Unit
//) {
//    val completion = AsyncCoroutine(coroutineContext)
//    block.startCoroutine(completion, completion)
//}

class AsyncCoroutine(override val context: CoroutineContext = EmptyCoroutineContext) : Continuation<Unit>, AsyncScope {
    override fun resumeWith(result: Result<Unit>) {
        result.getOrThrow()
    }
}

suspend fun <T> AsyncScope.await(block: () -> Callable<T>) = suspendCoroutine<T> {
    val call = block()


}