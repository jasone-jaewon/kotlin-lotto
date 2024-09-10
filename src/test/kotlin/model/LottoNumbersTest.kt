package model

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoNumbersTest {
    @Test
    fun `로또 숫자의 갯수는 6개이다`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        // when & then
        LottoNumbers(numbers)
    }

    @Test
    fun `로또 숫자의 갯수는 6개가 미만이면 예외가 발생한다`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5)

        // when & then
        assertThrows<IllegalArgumentException> { LottoNumbers(numbers) }
    }

    @Test
    fun `로또 숫자의 갯수는 6개가 초과되면 예외가 발생한다`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7)

        // when & then
        assertThrows<IllegalArgumentException> { LottoNumbers(numbers) }
    }

    @Test
    fun `로또 숫자는 모두 1에서 45 사이이다`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 44, 45)

        // when & then
        LottoNumbers(numbers)
    }

    @Test
    fun `로또 숫자는 모두 1에서 45 사이가 아니면 예외가 발생한다`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 44, 46)

        // when & then
        assertThrows<IllegalArgumentException> { LottoNumbers(numbers) }
    }

    @Test
    fun `매칭된 숫자 테스트 - 모두 매칭`() {
        // given
        val lottoNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        val otherNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)

        // when
        val matchedCount = lottoNumbers.match(otherNumbers)

        // then
        matchedCount shouldBe lottoNumbers.size
    }

    @Test
    fun `매칭된 숫자 테스트 - 5개 매칭`() {
        // given
        val lottoNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        val otherNumbers = LottoNumbers(1, 2, 3, 4, 6, 7)

        // when
        val matchedCount = lottoNumbers.match(otherNumbers)

        // then
        matchedCount shouldBe 5
    }
}
