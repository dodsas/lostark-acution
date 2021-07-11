package org.ys.lostark.market

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.stereotype.Service
import java.lang.RuntimeException

class Market(
    private val name: String,
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

    fun clone(): Market {
        return Market(name, count, lastPrice, price)
    }
}