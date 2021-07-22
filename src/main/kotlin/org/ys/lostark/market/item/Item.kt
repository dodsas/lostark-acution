package org.ys.lostark.market.item

import org.jsoup.select.Elements

private fun Elements.getCount(): Int {
    val originText = this[0].text()
    return "[0-9]+".toRegex().find(originText)?.value?.toInt()?:1
}

private fun Elements.getName(): String {
    val originText = this[0].text()
    return "[가-힣| |\\[|\\]]+".toRegex().find(originText)!!.value
        .replace("[일품]", "")
        .replace("[", "")
        .trim()
}

private fun Elements.getLastPrice(): Double {
    return this[2].text().toDouble()
}
private fun Elements.getPrice(): Double {
    return this[3].text().toDouble()
}

class Item(
    val name: String,
    val count: Int = 1,
    var lastPrice: Double = 0.0,
    var price: Double = 0.0,
)
{

    constructor(name:String, elementList: Elements) : this(
        elementList.getName(),
        elementList.getCount(),
        elementList.getLastPrice(),
        elementList.getPrice(),
    ){
        elementList.removeAt(0)
        elementList.removeAt(0)
        elementList.removeAt(0)
        elementList.removeAt(0)
    }
    companion object {
        private val emptyItem = Item("empty", 0)
        fun emptyItem(): Item {
            return emptyItem
        }
    }

    override fun toString(): String {
        return String.format("%5.2f %5.2f [%s]", price, price/count, name)
    }

    fun init(lastPrice: Double, price: Double){
        this.lastPrice = lastPrice
        this.price = price
    }

    fun costPerPiece() : Double{
        return price / count
    }

    fun sellPrice() : Double {
        return price - fee()
    }

    fun fee() : Double {
        val fee = price * 0.05
        return if(fee < 1) 1.0 else fee
    }

    fun clone(): Item {
        return Item(name, count, lastPrice, price)
    }
}