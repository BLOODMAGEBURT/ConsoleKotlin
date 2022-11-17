package offer

fun main() {

    println(doublePin(intArrayOf(1, 2, 4, 6, 10), 8))
}

/**
 * 输入一个递增排序的数组和一个值k，请问如何在数组中找出两个和为k的数字并返回它们的下标？
 * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
 * 例如，输入数组[1，2，4，6，10]，k的值为8，数组中的数字2与6的和为8，它们的下标分别为1与3
 */

fun doublePin(array: IntArray, target: Int): Pair<Int, Int>? {

    var first = 0

    var last = array.size - 1

    while (first < last) {

        if (array[first] + array[last] > target) {
            last -= 1
        } else if (array[first] + array[last] < target) {
            first += 1
        } else {
            return Pair(first, last)
        }
    }

    return null
}