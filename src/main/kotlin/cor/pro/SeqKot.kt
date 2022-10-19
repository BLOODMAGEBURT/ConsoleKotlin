package cor.pro

fun main() {

    primes(3).take(10).forEach { println(it) }

}


fun primes(start: Int): Sequence<Int> = sequence {
    var index = start
    while (true) {
        if (isPrime(index)) yield(index)
        index++
    }
}

fun isPrime(num: Int): Boolean {

    return (num > 1 && (2 until num).none { num % it == 0 })
}