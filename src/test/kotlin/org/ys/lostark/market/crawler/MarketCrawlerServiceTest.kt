package org.ys.lostark.market.crawler

import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.ys.lostark.market.MarketService

@SpringBootTest
internal class MarketCrawlerServiceTest {

    @Autowired
    lateinit var marketService: MarketCrawlerService

    @Test
    fun getItemInfo() {
        marketService.getItemInfo("오레하 두툼한 생고기")
        marketService.getItemInfo("질긴 가죽")
        marketService.getItemInfo("두툼한 생고기")
    }
}