package org.ys.lostark.market.crawler

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.stereotype.Service
import org.ys.lostark.market.item.Item
import java.lang.RuntimeException


@Service
class HtmlParser(
) {
    fun parse(itemName:String, htmlString:String) : Item {
        val doc: Document = Jsoup.parse(htmlString)
        val tags = doc.getElementsByAttribute("data-grade")
        if(tags.size != 4){
            throw RuntimeException("Item tags size should be 4")
        }
        val market = Item(
            itemName,
            1,
            tags[2].text().toDouble(),
            tags[3].text().toDouble(),
        )
        println(market)
        return market
    }
}