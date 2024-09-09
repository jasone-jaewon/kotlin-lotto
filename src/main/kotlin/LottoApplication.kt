import view.LottoInputView



fun main() {
    val lottoView = LottoInputView()
    val money = scanMoney(lottoView)
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