package cor.core


sealed class DisposableList {

    object Nil : DisposableList()

    class Cons(
        val head: Disposable,
        val tail: DisposableList
    ) : DisposableList()

}


fun DisposableList.remove(disposable: Disposable): DisposableList {

    return DisposableList.Nil
}
