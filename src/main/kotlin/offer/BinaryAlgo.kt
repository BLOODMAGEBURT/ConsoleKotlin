package offer

fun main() {

    println(showOnce(intArrayOf(2, 1, 2, 4, 1, 3, 4, 5, 5)))
}


/**
 *
 * 输入数组中除一个数字只出现一次之外其他数字都出现两次，请找出只出现一次的数字
 *
 *
 * 按位异或的3个特点：

　　（1） 0^0=0，0^1=1 0异或任何数＝任何数

　　（2） 1^0=1，1^1=0 1异或任何数－任何数取反

　　（3） 任何数异或自己＝把自己置0

 */
fun showOnce(array: IntArray): Int {

    var result = 0

    array.forEach {
        result = result xor it
    }

    return result
}