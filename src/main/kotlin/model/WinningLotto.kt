package model

data class WinningLotto(
    val lotto: Lotto,
    val bonus: Int
) {
    init {
        require(bonus !in lotto.numbers) {
            "보너스 번호는 당첨 로또 숫자 번호와 겹치면 안됩니다."
        }
    }

    constructor(lottoNumbers: LottoNumbers, bonusNumber: Int) : this(Lotto(lottoNumbers), bonusNumber)

    fun rank(matchedNum: Int, bonusMatch: Boolean): LottoRank {
        if (matchedNum == LottoRank.FIRST.matchedCount) {
            return LottoRank.FIRST
        }

        if (matchedNum == LottoRank.SECOND.matchedCount && bonusMatch) {
            return LottoRank.SECOND
        }

        if (matchedNum == LottoRank.THIRD.matchedCount && !bonusMatch) {
            return LottoRank.THIRD
        }

        if (matchedNum == LottoRank.FORTH.matchedCount) {
            return LottoRank.FORTH
        }

        if (matchedNum == LottoRank.FIFTH.matchedCount) {
            return LottoRank.FIFTH
        }
        return LottoRank.MISS
    }
}
