package cor.core

sealed class CoroutineState {

    private var disposableList: DisposableList = DisposableList.Nil

    object InComplete : CoroutineState()
    object Cancelling : CoroutineState()
    class Complete<T>(
        val value: T? = null,
        val exception: Throwable? = null
    ) : CoroutineState()


    fun from(state: CoroutineState): CoroutineState {
        this.disposableList = state.disposableList
        return this
    }

    fun with(disposable: Disposable): CoroutineState {
        this.disposableList = DisposableList.Cons(disposable, this.disposableList)
        return this
    }


    fun without(disposable: Disposable): CoroutineState {
        this.disposableList = this.disposableList.remove(disposable)
        return this
    }

    fun clear() {
        this.disposableList = DisposableList.Nil
    }

}
