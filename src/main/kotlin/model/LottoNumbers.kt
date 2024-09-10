package model

class LottoNumbers(
    val numbers: List<Int>
) : List<Int> by numbers {

    init {
        require(numbers.size == 6) {
            "[ERROR] 정상적인 로토 번호 조합이 아닙니다."
        }

        require(numbers.all { it in 1..45 }) {
            "[ERROR] 정상적인 로토 번호가 아닙니다."
        }
    }

    constructor(vararg numbers: Int) : this(numbers.toList())

    fun match(lottoNumbers: LottoNumbers): Int {
        return numbers.intersect(lottoNumbers.toSet()).size
    }

    fun matchBonus(bonusNum: Int): Boolean {
        TODO()
    }
}
