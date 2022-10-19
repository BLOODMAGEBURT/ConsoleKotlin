import java.math.RoundingMode
import java.net.URLDecoder
import java.text.DecimalFormat
import java.util.LinkedList
import java.util.regex.Pattern
import kotlin.random.Random

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
//    println("Program arguments: ${args.joinToString()}")
//
//
//    val listOf = listOf(2, 34, 65, 766)
//
//    var x = 1
//    var y = 2
//    x = y.apply { y = x }
//    println("$x $y")
//
//    println(listOf.joinToString("|"))
//
//    val list = LinkedList<String>()
//
//    //左闭右开
//    println("${listOf(1, 2, 3, 4).subList(1, 4)}")
//
//    println("20220722201500".substring(8, 10))
//    println("20220722201500".substring(10, 12))
//
//
//    println(generateMailCode())
//
//    val bean = NoticeCenterItemBean(1, "知识", 0L, "hello world", 0)
//
//    println("${bean.toModel()}")

//    val url = URLDecoder.decode(
//        "https%3A%2F%2Ffile.szfiu.com%2Fus-notice%2Ffiling%2Fconvpdf%2F2022%2F07%2F26%2F15967138.pdf",
//        "utf-8"
//    )
//    println(url)
//
//    val df2 = DecimalFormat("#,##0.00") // 数字格式转换,保留2位小数
//    df2.roundingMode = RoundingMode.HALF_UP
//    println(df2.format(812.115))


    val time = System.currentTimeMillis()

    val month = time / (1000*60*60*24*30L)
    val month1 = time / 30L
    println("time: $time month: $month  $month1")

    println("${(2023-1970)*12}")

}

fun generateMailCode(): String {
    val codeBytes = CharArray(6)

    (0..5).forEach {
        codeBytes[it] = '0' + Random.nextInt(10)
    }

    return String(codeBytes)
}

fun reMatch(str: String): Boolean {

    val regexRule = "^(?![a-z]+$)(?![A-Z]+$)(?![\\W_]+$)(?![\\d]+$)[a-zA-Z\\d_\\W]{6,20}$"

//    Pattern.matches(regexRule, str)

    return Regex(regexRule).matches(str)

}