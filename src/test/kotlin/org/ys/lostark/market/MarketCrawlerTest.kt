package org.ys.lostark.market

import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class MarketCrawlerTest{

    @Autowired
    private lateinit var marketCrawler: MarketCrawler

    @Autowired
    private lateinit var marketHtmlParser: MarketHtmlParser

    @Test
    fun test1() {
        val value = marketCrawler.getItemValue("하급 오레하 융화 재료")
        println(value)
        marketHtmlParser.parse("하급 오레하 융화 재료", value)
    }
}