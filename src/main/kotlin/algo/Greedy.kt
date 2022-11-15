package algo

/**
 * 贪婪算法
 */
fun main() {

    val a = State("a", listOf(2, 4, 5))
    val b = State("b", listOf(2, 6, 9))
    val c = State("c", listOf(1, 3, 9))
    val d = State("d", listOf(2, 5, 6))
    val e = State("e", listOf(4, 7))
    val f = State("f", listOf(5, 8, 9))
    val g = State("g", listOf(1))


    val tabs = listOf(a, b, c, d, e, f, g)

    greedy(tabs)

}

data class State(val name: String, val num: List<Int>)

fun greedy(tabs: List<State>): List<State> {

    val results = mutableListOf<State>()

    val need = tabs.flatMap { it.num }.toMutableSet()

    while (need.isNotEmpty()) {

        var best: State? = null

        var covered = setOf<Int>()

        tabs.forEach {

            val newCovered = need intersect it.num.toSet()

            if (newCovered.size > covered.size) {
                best = it
                covered = newCovered
            }
        }

        best?.let {
            results.add(it)
        }
        need -= covered
    }


    println(results.map { it.name })



    return results
}


