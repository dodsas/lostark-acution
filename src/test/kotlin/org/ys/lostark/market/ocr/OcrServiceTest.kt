package org.ys.lostark.market.ocr

import org.junit.jupiter.api.Test

internal class OcrServiceTest {

    @Test
    fun grep() {
        val marketOcr = OcrService()
        marketOcr.getMarketListByOcr("1")
        marketOcr.getMarketListByOcr("2")
    }
}