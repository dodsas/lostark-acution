package org.ys.lostark.market.receipt

import org.junit.jupiter.api.Test

internal class ReceiptServiceTest {

    @Test
    fun prepare() {
        val marketReceipt = ReceiptService()
        marketReceipt.prepare()
    }
}