import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime

fun main() {
    val regex = """(.{2,}\.){2,}.*""".toRegex()

    println(regex.matches("pre.baidu.du.com/#/withdrawFunds"))
    println(regex.matches("192.168.230.251:8021/#/depositFunds"))
    println(regex.matches("192.168/#/depositFunds"))
    println(regex.matches("https://47.241.77.177:13001"))
    println(regex.matches("https://www.baidu.com:8021/#/depositFunds"))
    println(regex.matches("192.168.230.251:8021/#/stockTransferOut/outguide?us=1"))


    /**
     * continue
     */
    (1..10).forEach {
        if (it == 5) {
            return@forEach
        }
        println(it)
    }

    /**
     * break
     */
    run lit@{
        (21..30).forEach {
            if (it == 25) {
                return@lit
            }
            println(it)
        }
    }


    val result = when {
        "2023-04-01" > "" -> "1"
        "2023-03-15" < "2023-03-14" -> "2"
        "2023-03-15" < "2023-03-14" -> "3"
        else -> "10"
    }
    println("result = $result")


    println("0.00".toDouble() == 0.0)

    LocalDateTime.parse("2021-01-01T13:40:50").let {
        println(it)
    }

    LocalDate.parse("2021-01-01").let {
        println(it)
    }

    LocalDate(2021, 2, 10).let {
        println(it)
    }

    LocalTime(13, 40, 50).let {
        println(it)
    }
    LocalTime(2, 40).let {
        println(it)
    }

    LocalTime.parse("20:02").let {
        println(it)
    }

    val (year, month, day) = readln().split("-").map { it.toInt() }
    println("year = $year, month = $month, day = $day")
}