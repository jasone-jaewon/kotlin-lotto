package controller

import generateLottoNumbers
import model.Lotto

class LottoController {

    fun createLotto(games: Int): List<Lotto> {
        return buildList {
            for (n in 1..games) {
                add(Lotto(generateLottoNumbers()))
            }
        }
    }
}
