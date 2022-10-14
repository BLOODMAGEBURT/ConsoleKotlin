package cor.pro

import kotlin.coroutines.*


/**
 * 复合协程， 模仿python的序列生成器
 */
fun main() {

    val fib = sequence {
        yield(1L)
        var current = 1L
        var next = 1L
        while (true) {
            yield(next)
            next += current
            current = next - current
        }
    }

    fib.take(10).forEach(::println)
}


fun <T> generator(block: (T) -> Unit) {


}

interface Generator<T> {
    operator fun iterator(): Iterator<T>
}

interface GeneratorScope<T> {
    suspend fun yield(value: T)
}

sealed class State {
    class NotReady(val continuation: Continuation<Unit>) : State()
    class Ready<T>(val continuation: Continuation<Unit>, val nextValue: T) : State()
    object Done : State()
}


class GeneratorIterator<T>(
    private val block: suspend GeneratorScope<T>.(T) -> Unit,
    private val parameter: T
) : GeneratorScope<T>, Continuation<Any?>, Iterator<T> {

    private var state: State

    init {
        val coroutineBlock: suspend GeneratorScope<T>.() -> Unit =
            { block(parameter) }
        val start = coroutineBlock.createCoroutine(this, this)
        state = State.NotReady(start)
    }


    override suspend fun yield(value: T) = suspendCoroutine<Unit> {
        state = when (state) {
            is State.NotReady -> State.Ready(it, value)
            is State.Ready<*> -> throw IllegalStateException("Cannot yield a value while ready.")
            State.Done -> throw IllegalStateException("Cannot yield a value while done.")
        }

    }

    override val context: CoroutineContext
        get() = EmptyCoroutineContext

    override fun resumeWith(result: Result<Any?>) {
        state = State.Done
        result.getOrThrow()
    }

    override fun hasNext(): Boolean {
        return state != State.Done
    }

    override fun next(): T {
        return when (val currentState = state) {
            is State.NotReady -> {
                resume()
                return next()
            }

            is State.Ready<*> -> {
                state = State.NotReady(currentState.continuation)
                (currentState as State.Ready<T>).nextValue
            }

            State.Done -> throw IndexOutOfBoundsException("No value left.")

        }
    }

    private fun resume() {
        when (val currentState = state) {
            is State.NotReady -> currentState.continuation.resume(Unit)
            else -> {}
        }
    }
}
