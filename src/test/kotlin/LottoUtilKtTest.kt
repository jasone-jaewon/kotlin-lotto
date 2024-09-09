import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoUtilKtTest{
    @Test
    fun calculateLotteryGames1() {
        val results = calculateLotteryGames(15000)
        assertThat(results).isEqualTo(15)
    }

    @Test
    fun calculateLotteryGames2() {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> { calculateLotteryGames(-1000)  }
    }

    @Test
    fun calculateLotteryGames3() {
        val results = calculateLotteryGames(12300)
        assertThat(results).isEqualTo(12)
    }

    @Test
    fun `generateLottoNumbersTest`() {
        // when
        val numbers = generateLottoNumbers()

        // then
        numbers.size shouldBe 6
    }
}