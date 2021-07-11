package org.ys.lostark.market

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.stereotype.Service
import java.lang.RuntimeException

class Market(
    private val name: String,
    private val yesterdayAveragePrice:Double,
    private val lastPrice: Double,
    private val price: Double,
)
{

    override fun toString(): String {
        return "name : $name , price : $price"
    }
}