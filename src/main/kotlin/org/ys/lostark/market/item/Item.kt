package org.ys.lostark.market.item

class Item(
    val name: String,
    private val count: Int = 1,
    private var lastPrice: Double = 0.0,
    private var price: Double = 0.0,
)
{

    override fun toString(): String {
//        return "[name] $name [price] $price"
        return String.format("%5.2f %5.2f [%s]", price, price/count, name)
    }

    fun init(lastPrice: Double, price: Double){
        this.lastPrice = lastPrice
        this.price = price
    }

    fun costPerPiece() : Double{
        return price / count
    }

    fun clone(): Item {
        return Item(name, count, lastPrice, price)
    }
}