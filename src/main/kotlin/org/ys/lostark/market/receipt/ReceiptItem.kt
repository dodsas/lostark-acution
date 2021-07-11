package org.ys.lostark.market.receipt

import org.ys.lostark.market.item.Item
import kotlin.math.roundToInt

class ReceiptItem(
    private val itemName: String,
    private val count: Int,
) {

    var item = Item.emptyItem()
    fun link(itemList: List<Item>){
        item = itemList.stream().filter {c -> c.name == itemName}.findFirst().orElseThrow()
    }

    fun calculateCost(): Double {
        return count * item.costPerPiece()
    }

    override fun toString(): String {
        return if(item != Item.emptyItem()){
            String.format("%-5d(%2d)    %4.0f %s [${item.count}]", count, ((count * 30.0) / item.count).roundToInt(), item.price, itemName)
        } else {
            String.format("%4d %s", count, itemName)
        }
    }
}