package org.ys.lostark.market.ocr

import org.junit.jupiter.api.Test

internal class MarketOcrServiceTest {

    @Test
    fun grep() {
        val marketOcr = MarketOcrService()
        marketOcr.getMarketListByOcr("1")
        marketOcr.getMarketListByOcr("2")
    }
}