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
        if(tags.size < 4 || tags.size % 4 != 0){
            throw RuntimeException("Item tags size should be 4")
        }

        val itemList = mutableListOf<Item>()
        while(tags.size > 0){
            itemList.add (Item(itemName, tags))
        }

        itemList.sortByDescending { it.count }
        val item = itemList.first { it.name == itemName }
//        val market = Item(
//            itemName,
//            bundleCount,
//            tags[index + 2].text().toDouble(),
//            tags[index + 3].text().toDouble(),
//        )
        println(item)
        return item
    }
}