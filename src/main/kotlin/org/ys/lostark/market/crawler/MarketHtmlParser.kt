package org.ys.lostark.market.crawler

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.stereotype.Service
import org.ys.lostark.market.Market
import java.lang.RuntimeException


@Service
class MarketHtmlParser(
) {
    fun parse(itemName:String, htmlString:String) : Market {
        val doc: Document = Jsoup.parse(htmlString)
        val tags = doc.getElementsByAttribute("data-grade")
        if(tags.size != 4){
            throw RuntimeException("Item tags size should be 4")
        }
        val market = Market(
            itemName,
            1,
            tags[2].text().toDouble(),
            tags[3].text().toDouble(),
        )
        println(market)
        return market
    }
}