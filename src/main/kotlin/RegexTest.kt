import java.util.regex.Pattern

fun main() {
    val regex = """(.{2,}\.){2,}.*""".toRegex()

    println(regex.matches("pre.baidu.du.com/#/withdrawFunds"))
    println(regex.matches("192.168.230.251:8021/#/depositFunds"))
    println(regex.matches("192.168/#/depositFunds"))
    println(regex.matches("https://47.241.77.177:13001"))
    println(regex.matches("https://www.baidu.com:8021/#/depositFunds"))
}