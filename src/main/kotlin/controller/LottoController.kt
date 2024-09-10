package controller

import generateLottoNumbers
import model.Lotto
import model.LottoNumbers
import model.WinningLotto

class LottoController {
    fun createLotto(games: Int): List<Lotto> {
        return List(games) { Lotto(generateLottoNumbers()) }
    }

    fun createWinningLotto(lottoNumbers: LottoNumbers, bonusNumber: Int): WinningLotto {
        TODO()
    }
}
