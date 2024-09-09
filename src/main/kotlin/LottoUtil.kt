private const val DIVIDE_UNIT = 1000
private const val ZERO = 0
fun calculateLotteryGames(money: Int): Int {
    require(money >= ZERO) {
        "입력한 금액은 양수여야 합니다."
    }

    return money / DIVIDE_UNIT
}
