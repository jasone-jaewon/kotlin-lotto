package model

class LottoResult (val results : Map<LottoRank, Int>) : Map<LottoRank, Int> by results {

}