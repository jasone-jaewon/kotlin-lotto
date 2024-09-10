package controller

import io.kotest.matchers.shouldBe
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
}
