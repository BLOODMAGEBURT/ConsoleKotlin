package algo

fun main() {

    println(binarySearch(listOf(1, 3, 5, 7, 9), 3))
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
