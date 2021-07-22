package org.ys.lostark.market.crawler

import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class CrawlerServiceTest {

    @Autowired
    lateinit var service: CrawlerService

    @Test
    fun getItemInfo() {
        service.getItemInfo("장인의 노릇한 꼬치구이")
    }
}