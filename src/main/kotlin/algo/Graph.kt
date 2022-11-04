package algo

import java.util.concurrent.ArrayBlockingQueue

fun main() {


    val duanZhengMing = Friend("duanZhengMing", listOf(), true)
    val wangYuYang = Friend("wangYuYang", listOf(), false)
    val yeErNiang = Friend("yeErNiang", listOf(), false)
    val duanZQ = Friend("duanZQ", listOf(duanZhengMing), false)


    val duanYu = Friend("duanYu", listOf(duanZQ, wangYuYang), false)
    val xuZhu = Friend("xuZhu", listOf(yeErNiang), false)
    val aZhu = Friend("aZhu", listOf(duanYu, duanZQ), false)
    val aZi = Friend("aZi", listOf(), false)

    val myself = Friend("bobo", listOf(xuZhu, aZhu, duanYu, aZi), false)

    val allFriends = ArrayBlockingQueue<Friend>(10, false)

    allFriends.addAll(myself.friends)


    println(findEmpire(allFriends)?.name)


}

/**
 * BFS
 * 内圈 -> 外圈
 */
fun findEmpire(allFriends: ArrayBlockingQueue<Friend>): Friend? {

    val searched = mutableSetOf<Friend>()

    while (allFriends.iterator().hasNext()) {
        val f = allFriends.poll()
        if (f in searched) continue
        if (f.dealer) {
            return f
        } else {
            allFriends.addAll(f.friends)
        }
        searched.add(f)
    }
    return null
}


data class Friend(val name: String, val friends: List<Friend> = emptyList(), val dealer: Boolean = false)


