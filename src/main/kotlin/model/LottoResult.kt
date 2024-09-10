package model

class LottoResult(val results: Map<LottoRank, Int>) : Map<LottoRank, Int> by results {
    fun calculateTotalPrize(): Long {
        return results.map { it.value * it.key.prize }.sum()
    }
}
