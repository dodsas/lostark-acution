package org.ys.lostark.market

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class MarketService(
    private val marketCrawler: MarketCrawler,
    private val marketHtmlParser: MarketHtmlParser,
)
{
    fun getItemInfo(itemName:String) {
        val html = marketCrawler.getItemValue(itemName)
        val marketItem = marketHtmlParser.parse(itemName, html)
        println(marketItem)
    }
}