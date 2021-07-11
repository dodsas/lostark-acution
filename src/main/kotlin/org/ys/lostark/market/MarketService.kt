package org.ys.lostark.market

import org.springframework.stereotype.Service
import org.ys.lostark.market.crawler.MarketCrawler
import org.ys.lostark.market.crawler.MarketCrawlerService
import org.ys.lostark.market.crawler.MarketHtmlParser
import org.ys.lostark.market.ocr.MarketOcrService

@Service
class MarketService(
    private val marketCrawlerService: MarketCrawlerService,
    private val marketOcrService: MarketOcrService,
)
{
    fun progress() {
        val dataList = mutableListOf<Market>()
        dataList.add(marketCrawlerService.getItemInfo("하급 오레하 융화 재료"))
        dataList.addAll(marketOcrService.getMarketListByOcr("1"))
        dataList.addAll(marketOcrService.getMarketListByOcr("2"))
        dataList.addAll(marketOcrService.getMarketListByOcr("3"))
        dataList.addAll(marketOcrService.getMarketListByOcr("4"))

        println(dataList)
    }
}