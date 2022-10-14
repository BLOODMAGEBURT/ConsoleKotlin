package cor.job

import cor.core.CoroutineState
import cor.core.Disposable
import cor.core.OnCancel
import cor.core.OnComplete
import java.util.concurrent.atomic.AtomicReference
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext

abstract class AbstractCoroutine<T>(context: CoroutineContext) : Job, Continuation<T> {
    private val state = AtomicReference<CoroutineState>()

    final override val context: CoroutineContext

    init {
        state.set(CoroutineState.InComplete)
        this.context = context + this
    }

    val isComplete
        get() = state.get() is CoroutineState.Complete<*>

    override val isActive: Boolean
        get() = when (state.get()) {
            is CoroutineState.Complete<*>, is CoroutineState.Cancelling -> false
            else -> true
        }


    override fun cancel() {
        state.updateAndGet {
            when (it) {
                is CoroutineState.InComplete -> CoroutineState.InComplete
                is CoroutineState.Cancelling -> CoroutineState.Cancelling
                is CoroutineState.Complete<*> -> CoroutineState.Complete("")
                else -> CoroutineState.InComplete
            }
        }
    }

    override fun resumeWith(result: Result<T>) {
    }

    override fun join() {
        TODO("Not yet implemented")
    }

    override fun invokeOnCancel(onCancel: OnCancel): Disposable {
        TODO("Not yet implemented")
    }

    override fun invokeOnCompletion(onComplete: OnComplete): Disposable {
        TODO("Not yet implemented")
    }

    override fun remove(disposable: Disposable) {
        TODO("Not yet implemented")
    }

}


