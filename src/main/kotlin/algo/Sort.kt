package algo

import java.util.Arrays

fun main() {
    selectSort(listOf(1, 10, 6, 2, 7, 4, 8, 3))
    quickSort(listOf(1, 10, 6, 2, 7, 4, 8, 3))

    println(findMin(listOf(16, 10, 6, 2, 7, 4, 8, 3)))


    println(arrayOf(1, 10, 6, 2, 7, 4, 8, 3).swap(0, 1).contentToString())
}


fun selectSort(list: List<Int>): List<Int> {
    val sortList = mutableListOf<Int>()

    val size = list.size
    for (i in 0 until size) {

        for (j in i + 1 until size) {

        }
    }


    return sortList
}


fun quickSort(list: List<Int>): List<Int> {

    return emptyList()
}


private fun findMin(list: List<Int>): Int {

    var min = list[0]
    list.forEach {
        if (min > it) {
            min = it
        }
    }
    return min
}

fun <T> Array<T>.swap(first: Int, second: Int): Array<T> {
    this[first] = this[second].also {
        this[second] = this[first]
    }
    return this
}