package controller

import io.kotest.matchers.shouldBe
import model.Lotto
import model.LottoNumbers
import model.LottoResult
import model.WinningLotto
import model.LottoRank
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
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 45
        val expected = WinningLotto(Lotto(LottoNumbers(lottoNumbers)), bonusNumber)

        // when
        val winningLotto = lottoController.createWinningLotto(lottoNumbers, bonusNumber)

        // then
        winningLotto.lotto shouldBe expected.lotto
        winningLotto.bonus shouldBe expected.bonus
    }

    @Test
    fun `로또 당첨 결과 맵 생성`() {
        val lottoNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        val userLottos = listOf(Lotto(LottoNumbers(1, 2, 3, 4, 5, 6)))
        val bonusNumber = 45
        val winningLotto = WinningLotto(lottoNumbers, bonusNumber)

        val result = lottoController.getWinningResults(userLottos, winningLotto)

        result.size shouldBe 1
        result[LottoRank.FIRST] shouldBe 1
    }

    @Test
    fun `당첨 수익률 계산`() {
        val lottoResult = LottoResult(
            mapOf(LottoRank.FIFTH to 5, LottoRank.FORTH to 3)
        )
        val totalPrice = 500000
        val expected = 0.35

        val actual = lottoController.calculateWinningRate(lottoResult, totalPrice)

        actual shouldBe expected
    }
}
