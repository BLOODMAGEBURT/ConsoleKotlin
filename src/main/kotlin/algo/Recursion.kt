package algo

import cor.job.launch
import cor.pro.delay
import kotlinx.coroutines.coroutineScope

suspend fun main() {

//    countDown(10)

    println(gcd(6, 48))

    println(sumArray(intArrayOf(1, 4, 7)))

    println(listSize(listOf(1, 2, 3, 4, 5, 6, 7)))

    println(max(listOf(1, 2, 3, 4, 15, 5, 6, 7, 10)))


}

suspend fun countDown(top: Int) {

    // 基线条件
    if (top == 0) {
        return
    }

    println(top)
    coroutineScope {
        delay(1500)
        // 循环调用
        countDown(top - 1)
    }

}

/**
 * Greatest Common Divisor
 * GCD
 * 欧几里得辗转相除法
 */
fun gcd(a: Int, b: Int): Int {
    if (a == 0) return b
    if (b == 0) return a
    if (a == b) return a

    if (a > b) {
        return gcd(b, a % b)
    }
    return gcd(a, b % a)
}

/**
 * calculate sum with recursion
 *
 * D&C
 */

fun sumArray(array: IntArray): Int {
    if (array.isEmpty()) {
        return 0
    }
    if (array.size == 1) {
        return array[0]
    }

    return array[0] + sumArray(array.sliceArray(1 until array.size))
}

fun listSize(list: List<Int>): Int {

    if (list.isEmpty()) {
        return 0
    }
    return 1 + listSize(list.subList(1, list.size))

}


fun max(list: List<Int>): Int {
    if (list.isEmpty()) {
        return 0
    }

    return if (list[0] > max(list.subList(1, list.size))) {
        list[0]
    } else {
        max(list.subList(1, list.size))
    }
}