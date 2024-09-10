package controller

import generateLottoNumbers
import model.Lotto
import model.LottoNumbers
import model.WinningLotto

class LottoController {
    fun createLotto(games: Int): List<Lotto> {
        return List(games) { Lotto(generateLottoNumbers()) }
    }

    fun createWinningLotto(lottoNumbers: List<Int>, bonusNumber: Int): WinningLotto {
        return WinningLotto(LottoNumbers(lottoNumbers), bonusNumber)
    }
}
