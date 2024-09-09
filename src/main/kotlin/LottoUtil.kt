import model.LottoNumbers

private const val DIVIDE_UNIT = 1000
private const val ZERO = 0
private const val MINIMUM_LOTTO_NUM = 1
private const val MAXIMUM_LOTTO_NUM = 45
private const val MAX_NUM = 5

fun calculateLotteryGames(money: Int): Int {
    require(money >= ZERO) {
        "입력한 금액은 양수여야 합니다."
    }

    return money / DIVIDE_UNIT
}

fun generateLottoNumbers () : LottoNumbers {
    val numbers = (MINIMUM_LOTTO_NUM.. MAXIMUM_LOTTO_NUM).shuffled().slice(ZERO..MAX_NUM).sorted()
    return LottoNumbers(numbers)
}