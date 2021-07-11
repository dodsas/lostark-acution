package org.ys.lostark.market.crawler

import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class CrawlerTest{

    @Autowired
    private lateinit var crawler: Crawler

    @Autowired
    private lateinit var htmlParser: HtmlParser

    @Test
    fun parse() {
        val value = crawler.getItemValue("하급 오레하 융화 재료")
        println(value)
        htmlParser.parse("하급 오레하 융화 재료", value)
    }
}