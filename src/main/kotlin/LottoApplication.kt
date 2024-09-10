import controller.LottoController
import view.LottoInputView

val lottoController = LottoController()

fun main() {
    val lottoView = LottoInputView()
    val money = scanMoney(lottoView)
    val games = calculateLotteryGames(money)
    val lottos = lottoController.createLotto(games)
}

private fun scanMoney(lottoView: LottoInputView): Int {
    while (true) {
        try {
            lottoView.printMoneyInput()
            return lottoView.scanMoney()
        } catch (e: NumberFormatException) {
            println("[ERROR] 숫자 타입으로 입력해주세요.")
        }
    }
}

private fun scanWinningMoney(lottoView: LottoInputView): List<Int> {
    while (true) {
        try {
            lottoView.printWinningNumberInput()
            return lottoView.scanWinningNumber().split(',').map { it.trim().toInt() }
        } catch (e: NumberFormatException) {
            println("[ERROR] 숫자 타입으로 입력해주세요.")
        }
    }
}

private fun scanBonusNumber(lottoView: LottoInputView): Int {
    while (true) {
        try {
            lottoView.printBonusNumberInput()
            return lottoView.scanBonusNumber()
        } catch (e: NumberFormatException) {
            println("[ERROR] 숫자 타입으로 입력해주세요.")
        }
    }
}
