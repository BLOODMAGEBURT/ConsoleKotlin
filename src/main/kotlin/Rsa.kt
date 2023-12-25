import java.util.Base64

fun main() {

    val encode = base64Encode("hello world")

    println("encoded: ${encode.joinToString(",")}")
    println("encoded: ${encode.decodeToString()}")

//    val decoded = base64Decode(encode)



//    println("decoded: ${decoded.joinToString(",")}")


}


fun base64Encode(data: String): ByteArray = Base64.getEncoder().encode(data.toByteArray())

fun base64Decode(data: String): ByteArray = Base64.getDecoder().decode(data)