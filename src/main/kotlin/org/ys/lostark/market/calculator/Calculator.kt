package org.ys.lostark.market.calculator

import org.ys.lostark.market.item.Item
import org.ys.lostark.market.receipt.Receipt
import org.ys.lostark.market.receipt.ReceiptItem

class Calculator {

    fun calculate(receipt: Receipt, itemList: List<Item>) {
        var cost = receipt.baseCost
        var revenue = 0.0

        for (receiptItem: ReceiptItem in receipt.inputs) {
            val item = itemList.stream().filter {c -> c.name == receiptItem.itemName}.findFirst().orElseThrow()
            cost += receiptItem.calculateCost(item)
        }

        val item = itemList.stream().filter {c -> c.name == receipt.output.itemName}.findFirst().orElseThrow()
        revenue = (receipt.output.calculateCost(item)*0.95) - cost

        println(receipt)
        println("cost    : $cost")
        println("revenue : $revenue")
        println("------------------------")
    }
}