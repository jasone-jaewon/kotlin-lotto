package view

class LottoInputView {
    companion object {
        const val MESSAGE_MONEY_PREFIX = "구입금액을 입력해 주세요."
    }

    fun printMoneyInput() {
        println(MESSAGE_MONEY_PREFIX)
    }

    fun scanMoney(): Int {
        return readln().toInt()
    }
}