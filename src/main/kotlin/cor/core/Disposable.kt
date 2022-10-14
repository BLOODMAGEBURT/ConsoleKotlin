package cor.core

interface Disposable {
    fun dispose()
}

typealias OnComplete = (cause: Throwable?) -> Unit

typealias OnCancel = (cause: Throwable?) -> Unit