package algo


fun main() {
//    println(selectSort(intArrayOf(5, 1, 10, 6, 2, 7, 4, 8, 3, 6)).contentToString())
    println(quickSort(listOf(1, 10, 6, 2, 7, 4, 8, 3)))

//    println(findMin(listOf(16, 10, 6, 2, 7, 4, 8, 3)))


//    println(arrayOf(1, 10, 6, 2, 7, 4, 8, 3).swap(0, 1).contentToString())
}

/**
 * select sort
 */
fun selectSort(array: IntArray): IntArray {
    val size = array.size
    for (i in 0 until size) {
        var minIndex = i
        var min = array[i]
        for (j in i + 1 until size) {
            // 寻找最小值
            if (min > array[j]) {
                min = array[j]
                minIndex = j
            }
        }
        if (i == minIndex) {
            println("continue $i ${array[i]}")
            continue
        }
        // 元素交换,只进行一次
        array[i] = array[minIndex].also {
            array[minIndex] = array[i]
        }
    }


    return array
}

/**
 * quick sort  recursion
 * D&C
 */
fun quickSort(list: List<Int>): List<Int> {
    if (list.size < 2) {
        return list
    }

    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()

    for (i in 1 until list.size) {

        if (list[i] < list.first()) {
            left.add(list[i])
        } else {
            right.add(list[i])
        }
    }
    return quickSort(left) + list.first() + quickSort(right)
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