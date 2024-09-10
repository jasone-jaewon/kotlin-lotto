package view

import model.Lotto
import model.LottoRank
import model.LottoResult

class LottoInputView {
    companion object {
        const val MESSAGE_MONEY_PREFIX = "구입금액을 입력해 주세요."
        const val MESSAGE_WINNINGNUMBER_PREFIX = "지난 주 당첨 번호를 입력해 주세요."
        const val MESSAGE_BONUSNUMBER_PREFIX = "보너스 볼을 입력해 주세요."
    }

    fun printMoneyInput() {
        println(MESSAGE_MONEY_PREFIX)
    }

    fun scanMoney(): Int {
        return readln().toInt()
    }

    fun printWinningNumberInput() {
        println(MESSAGE_WINNINGNUMBER_PREFIX)
    }

    fun scanWinningNumber(): String {
        return readln()
    }

    fun printBonusNumberInput() {
        println(MESSAGE_BONUSNUMBER_PREFIX)
    }

    fun scanBonusNumber(): Int {
        return readln().toInt()
    }

    fun printLottos(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매하셨습니다.")
        lottos.forEach { println(it.numbers.numbers) }
    }

    fun printLottoPrize(lottoResult: LottoResult) {
        LottoRank.values().forEach {
            println("${it.matchedCount}개 일치 (${it.prize}원) - ${lottoResult[it] ?: 0}개")
        }
    }
}
