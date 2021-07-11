package org.ys.lostark.market.receipt

import org.ys.lostark.market.item.Item

class ReceiptItem(
    val itemName: String,
    val count: Int,
) {

    fun calculateCost(item: Item): Double {
        return count * item.costPerPiece()
    }
}