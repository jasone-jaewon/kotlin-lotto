package model

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {
    @Test
    fun `보너스 번호 테스트 중복여부 - 예외`() {
        val bonus = 15
        val lotto = Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 15)))

        assertThrows<IllegalArgumentException> { WinningLotto(lotto, bonus) }
    }

    @Test
    fun `보너스 번호 테스트 중복여부 - 정상`() {
        val bonus = 18
        val lotto = Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 15)))

        WinningLotto(lotto, bonus)
    }

    @Test
    fun `1등 테스트`() {
        val winningLottoNum = Lotto(LottoNumbers(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(winningLottoNum, 45)

        val rank = winningLotto.rank(6, true)

        rank shouldBe 1
    }

    @Test
    fun `2등 테스트`() {
        val winningLottoNum = Lotto(LottoNumbers(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(winningLottoNum, 45)

        val rank = winningLotto.rank(5, true)

        rank shouldBe 2
    }

    @Test
    fun `3등 테스트`() {
        val winningLottoNum = Lotto(LottoNumbers(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(winningLottoNum, 45)

        val rank = winningLotto.rank(5, false)

        rank shouldBe 3
    }

    @Test
    fun `4등 테스트`() {
        val winningLottoNum = Lotto(LottoNumbers(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(winningLottoNum, 45)

        val rank = winningLotto.rank(4, true)

        rank shouldBe 4
    }

    @Test
    fun `5등 테스트`() {
        val winningLottoNum = Lotto(LottoNumbers(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(winningLottoNum, 45)

        val rank = winningLotto.rank(3, true)

        rank shouldBe 5
    }

    @Test
    fun `꽝 테스트`() {
        val winningLottoNum = Lotto(LottoNumbers(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(winningLottoNum, 45)

        val rank = winningLotto.rank(2, true)

        rank shouldBe 0
    }
}
