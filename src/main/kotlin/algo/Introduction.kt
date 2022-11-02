package algo

fun main() {

//    println(binarySearch(listOf(1, 3, 5, 7, 9), 3))
    println(binarySearchRecursion(listOf(1, 3, 4, 7, 9, 35), 3))
}

/**
 * 返回索引
 */
fun binarySearch(values: List<Int>, target: Int): Int {
    var start = 0
    var end = values.size - 1
    while (start <= end) {
        val half = (end + start) / 2
        val mid = values[half]
        println("start: $start  end: $end  half: $half mid: $mid")
        if (mid < target) {
            start = half + 1
        } else if (mid > target) {
            end = half - 1
        } else {
            return half
        }
    }
    return -1
}

/**
 * 递归的方式二分,是否存在
 */

fun binarySearchRecursion(values: List<Int>, target: Int): Int {

    println(values)

    if (values.isEmpty()) {
        return -1
    }

    if (values.size == 1) {
        return if (values[0] == target) 1 else -1
    }
    val end = values.size - 1
    val half = end / 2
    val mid = values[half]

    return if (mid < target) {
        binarySearchRecursion(values.subList(half + 1, end + 1), target)
    } else if (mid > target) {
        binarySearchRecursion(values.subList(0, half), target)
    } else {
        1
    }

}
