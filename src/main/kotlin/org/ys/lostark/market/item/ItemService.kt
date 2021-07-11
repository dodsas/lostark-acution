package org.ys.lostark.market.item

import org.springframework.stereotype.Service
import org.ys.lostark.market.crawler.CrawlerService
import org.ys.lostark.market.ocr.OcrService

@Service
class ItemService(
    private val crawlerService: CrawlerService,
    private val ocrService: OcrService,
)
{
    fun prepare() : List<Item> {
        val itemList = mutableListOf<Item>()
        itemList.add(crawlerService.getItemInfo("하급 오레하 융화 재료"))
        itemList.addAll(ocrService.getMarketListByOcr("1"))
        itemList.addAll(ocrService.getMarketListByOcr("2"))
        itemList.addAll(ocrService.getMarketListByOcr("3"))
        itemList.addAll(ocrService.getMarketListByOcr("4"))
        println(itemList)
        return itemList
    }
}