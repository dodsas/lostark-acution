package org.ys.lostark.market.linker

import org.springframework.stereotype.Service
import org.ys.lostark.market.item.Item
import org.ys.lostark.market.receipt.Receipt

@Service
class Linker {
    fun link(receiptList: List<Receipt>, itemList: List<Item>){
        for (receipt: Receipt in receiptList){
            receipt.link(itemList)
        }
    }
}