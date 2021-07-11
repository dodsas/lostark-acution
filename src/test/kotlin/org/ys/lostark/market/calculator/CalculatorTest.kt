package org.ys.lostark.market.calculator

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.ys.lostark.market.item.ItemService
import org.ys.lostark.market.receipt.Receipt
import org.ys.lostark.market.receipt.ReceiptService

@SpringBootTest
internal class CalculatorTest {

    @Autowired
    lateinit var receiptService: ReceiptService

    @Autowired
    lateinit var itemService: ItemService

    @Test
    fun calculate() {
        val receipts = receiptService.prepare()
        val items = itemService.prepare()

        val calculator = Calculator()
        for(receipt: Receipt in receipts){
            calculator.calculate(receipt, items)
        }
    }
}