package offer

fun main() {

    println(divideAlgo(10000000, 3))
    println(divideAlgoBinary(10000000, 3))
}


// 实现除法 O(n)
fun divideAlgo(big: Int, small: Int): Int {

    var value = big - small

    var n = 0

    while (value >= 0) {
        n++
        value -= small
    }

    return n
}

// 改进除法 O(logN)
fun divideAlgoBinary(big: Int, small: Int): Int {
    var n = 0
    var newBig = big
    while (newBig - small >= 0) {
        var value = small
        var quotient = 1
        while (newBig >= value + value) {
            value += value
            quotient += quotient
        }

        n += quotient
        newBig -= value
    }

    return n

}