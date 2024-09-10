package controller

import generateLottoNumbers
import model.Lotto

class LottoController {
    fun createLotto(games: Int): List<Lotto> {
        return List(games) { Lotto(generateLottoNumbers()) }
    }
}
