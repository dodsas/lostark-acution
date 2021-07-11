package org.ys.lostark.market.crawler

import org.springframework.stereotype.Service
import org.ys.lostark.market.Market

@Service
class CrawlerService(
    private val crawler: Crawler,
    private val htmlParser: HtmlParser,
)
{
    fun getItemInfo(itemName:String): Market {
        val html = crawler.getItemValue(itemName)
        val marketItem = htmlParser.parse(itemName, html)
        return marketItem
    }
}