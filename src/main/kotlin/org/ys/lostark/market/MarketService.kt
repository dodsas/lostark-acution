package org.ys.lostark.market

import org.springframework.stereotype.Service
import org.ys.lostark.market.crawler.MarketCrawler
import org.ys.lostark.market.crawler.MarketHtmlParser

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