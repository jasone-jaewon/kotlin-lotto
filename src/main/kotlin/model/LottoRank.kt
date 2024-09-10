package model

enum class LottoRank(
    val prize: Long,
    val matchedCount: Int,
) {
    FIRST(2000000000L, 6),
    SECOND(30000000L, 5),
    THIRD(1500000L, 5),
    FORTH(50000L, 4),
    FIFTH(5000L, 3),
    MISS(0L, 0),
    ;
}
