package org.ys.lostark.market

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class MarketServiceTest {

    @Autowired
    lateinit var marketService: MarketService

    @Test
    fun getItemInfo() {
        marketService.getItemInfo("오레하 두툼한 생고기")
        marketService.getItemInfo("질긴 가죽")
        marketService.getItemInfo("두툼한 생고기")
    }
}