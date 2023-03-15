fun main() {
    val regex = """(.{2,}\.){2,}.*""".toRegex()

    println(regex.matches("pre.baidu.du.com/#/withdrawFunds"))
    println(regex.matches("192.168.230.251:8021/#/depositFunds"))
    println(regex.matches("192.168/#/depositFunds"))
    println(regex.matches("https://47.241.77.177:13001"))
    println(regex.matches("https://www.baidu.com:8021/#/depositFunds"))
    println(regex.matches("192.168.230.251:8021/#/stockTransferOut/outguide?us=1"))


    (1..10).forEach {
        if (it == 5) {
            return@forEach
        }
        println(it)
    }


    val result = when {
        "2023-04-01" > "2023-03-14" -> "1"
        "2023-03-15" < "2023-03-14" -> "2"
        else -> "3"
    }
    println("result = $result")


}