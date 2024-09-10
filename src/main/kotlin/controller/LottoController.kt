package controller

import generateLottoNumbers
import model.Lotto

class LottoController {

    fun createLotto(games: Int): List<Lotto> {
        val list = mutableListOf<Lotto>()
        for(n in 1..games) {
            list.add(Lotto(generateLottoNumbers()))
        }
        return list
    }
}