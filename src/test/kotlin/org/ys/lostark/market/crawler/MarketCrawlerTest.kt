package org.ys.lostark.market.crawler

import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.ys.lostark.market.crawler.MarketCrawler
import org.ys.lostark.market.crawler.MarketHtmlParser

@SpringBootTest
internal class MarketCrawlerTest{

    @Autowired
    private lateinit var marketCrawler: MarketCrawler

    @Autowired
    private lateinit var marketHtmlParser: MarketHtmlParser

    @Test
    fun parse() {
        val value = marketCrawler.getItemValue("하급 오레하 융화 재료")
        println(value)
        marketHtmlParser.parse("하급 오레하 융화 재료", value)
    }
}