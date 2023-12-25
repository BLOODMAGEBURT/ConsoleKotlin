import cor.pro.await
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

sealed class NoticeTypeModel(open val msgId: Int)

data class Type10Model(
    override val msgId: Int,
    val title: String,
    val content: String,
    val dateTime: String,
    val afterOpen: String = "go_app"
) : NoticeTypeModel(msgId)

data class Type6Model(
    override val msgId: Int,
    val title: String = "",
    val content: String,
    val dateTime: String,
    val url: String,
    val afterOpen: String = "go_app",
    val needPayLogin: Boolean = false
) : NoticeTypeModel(msgId)


fun main() {
    println((Type10Model(2, "hao", "sdfsf", "desdoisdf") as NoticeTypeModel).msgId)




}




