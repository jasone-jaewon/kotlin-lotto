package controller

import generateLottoNumbers
import model.Lotto
import model.LottoNumbers
import model.LottoResult
import model.WinningLotto

class LottoController {
    fun createLotto(games: Int): List<Lotto> {
        return List(games) { Lotto(generateLottoNumbers()) }
    }

    fun createWinningLotto(lottoNumbers: List<Int>, bonusNumber: Int): WinningLotto {
        return WinningLotto(LottoNumbers(lottoNumbers), bonusNumber)
    }

    fun getWinningResults(lottos: List<Lotto>, winningLotto: WinningLotto): LottoResult {
        val prizeCountMap = lottos.map { lotto ->
            val matchedCount = winningLotto.lotto.numbers.match(lotto.numbers)
            val matchBonus = lotto.numbers.matchBonus(winningLotto.bonus)
            winningLotto.rank(matchedCount, matchBonus)
        }.groupingBy { it }.eachCount()

        return LottoResult(prizeCountMap)
    }
}
