package org.ys.lostark.market.receipt

import org.ys.lostark.market.item.Item
import java.lang.RuntimeException
import kotlin.math.roundToInt

class ReceiptItem(
    private val itemName: String,
    private val count: Int,
) {

    var item = Item.emptyItem()
    fun link(itemList: List<Item>){
        item = itemList.stream().filter {c -> c.name == itemName}.findFirst().orElseThrow{RuntimeException("${itemName}이(가) 없습니다")}
    }

    fun calculateCost(): Double {
        return count * item.costPerPiece()
    }

    fun getSellPrice() : Double {
        return item.sellPrice() * count
    }

    override fun toString(): String {
        return if(item != Item.emptyItem()){
            String.format("%-5d(%-3d)    %4.0f %s [${item.count}]", count, ((count * 40.0) / item.count).roundToInt(), item.price, itemName)
        } else {
            String.format("%4d %s", count, itemName)
        }
    }
}