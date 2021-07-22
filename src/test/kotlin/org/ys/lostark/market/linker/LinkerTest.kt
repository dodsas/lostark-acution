package org.ys.lostark.market.linker

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.ys.lostark.market.item.ItemService
import org.ys.lostark.market.receipt.Receipt
import org.ys.lostark.market.receipt.ReceiptService

@SpringBootTest
internal class LinkerTest {

    @Autowired
    lateinit var receiptService: ReceiptService

    @Autowired
    lateinit var itemService: ItemService

    @Test
    fun calculate() {
        val receipts = receiptService.prepare()
        val items = itemService.prepare()

        val linker = Linker()
        linker.link(receipts, items)

        receipts.sortedBy { it.revenue }.forEach { it.print() }
    }
}