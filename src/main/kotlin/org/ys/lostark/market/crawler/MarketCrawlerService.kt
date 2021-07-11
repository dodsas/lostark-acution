package org.ys.lostark.market.crawler

import org.springframework.stereotype.Service
import org.ys.lostark.market.Market
import org.ys.lostark.market.crawler.MarketCrawler
import org.ys.lostark.market.crawler.MarketHtmlParser

@Service
class MarketCrawlerService(
    private val marketCrawler: MarketCrawler,
    private val marketHtmlParser: MarketHtmlParser,
)
{
    fun getItemInfo(itemName:String): Market {
        val html = marketCrawler.getItemValue(itemName)
        val marketItem = marketHtmlParser.parse(itemName, html)
        return marketItem
    }
}