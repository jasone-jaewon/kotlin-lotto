package model

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
}
