package controller

import io.kotest.matchers.shouldBe
import model.Lotto
import model.LottoNumbers
import model.WinningLotto
import org.junit.jupiter.api.Test

internal class LottoControllerTest {
    private val lottoController = LottoController()

    @Test
    fun `게임에 맞는 로또를 반환한다`() {
        // given
        val games = 14

        // when
        val lottos = lottoController.createLotto(games)

        // then
        lottos.size shouldBe games
    }

    @Test
    fun `당첨 로또를 생성한다`() {
        // given
        val lottoNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        val bonusNumber = 45
        val expected = WinningLotto(Lotto(lottoNumbers), bonusNumber)

        // when
        val winningLotto = lottoController.createWinningLotto(lottoNumbers, bonusNumber)

        // then
        winningLotto shouldBe expected
    }
}
