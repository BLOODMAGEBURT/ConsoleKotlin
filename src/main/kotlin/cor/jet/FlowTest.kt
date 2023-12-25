package cor.jet

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

@OptIn(FlowPreview::class)
fun main() {

    fun foo() {
        println("foo")
    }
    runBlocking {

        launch {
            delay(500)
            foo()
        }

        fun simple() = flow {

            listOf(10, 9, 8, 7, 6, 5).forEach {
                delay(300)
                emit(it)
            }

        }

//        listOf(1, 2, 3).asFlow().collect(::println)
//
//        simple().collect {
//            println(it)
//        }
//        flowOf(1, 2, 3, 4, 5).collect(::println)

//        (1..5).asFlow()
//            .filter {
////                println("Filter $it")
//                it % 2 == 0
//            }
//            .map {
//                launch {
//                    println("Map $it")
//                }
//                async {
//                    delay(200)
//                    "string $it"
//                }
//            }.collect {
//                println("Collect ${it.await()}")
//            }


        fun exampleFlow() = flow {
            (1..10).forEach {
                delay(100)
                emit(it)
            }
        }

        exampleFlow()
            .conflate()
            .sample(500)
            .onEach {
                println(it)
                delay(600)
            }
            .collect()

    }


}