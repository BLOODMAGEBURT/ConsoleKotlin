package offer

fun main() {

    println(divideAlgo(8, 3))
}


// 实现除法
fun divideAlgo(big: Int, small: Int): Int {

    var value = big - small

    var n = 0

    while (value >= 0) {
        n++
        value -= small
    }

    return n
}