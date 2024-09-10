package model

class WinningLotto(
    private val lotto: Lotto,
    private val bonus: Int
) {
    init {
        require(bonus !in lotto.numbers) {
            "보너스 번호는 당첨 로또 숫자 번호와 겹치면 안됩니다."
        }
    }

    fun rank(matchedNum : Int, bonusMatch : Boolean) : Int {
        TODO()
    }
}