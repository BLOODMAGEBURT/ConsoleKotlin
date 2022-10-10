
/**
 * @Author Xu
 * Date：2022/3/25 5:02 下午
 * Description：
 */
data class NoticeItemModel(
    val cateId: Int,
    var hasNew: Boolean,
    val icon: Int,
    val typeTitle: String,
    var content: String? = null,
    var time: String? = null
)
