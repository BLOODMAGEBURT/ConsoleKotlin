data class NoticeCenterItemBean(
    var cateId: Int,
    var cateName: String,
    var ctime: Long?,
    var lastMsg: String?,
    var status: Int
) {
    private val icons =
        listOf(
            1, 2, 3, 4
        )


    fun toModel(): NoticeItemModel {

        return NoticeItemModel(
            cateId,
            status == 0,
            icons[cateId - 1],
            cateName,
            lastMsg,
            "${if (ctime == 0L) "" else ctime}"
        )
    }

}