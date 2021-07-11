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
    fun progress() {
        marketService.progress()
    }
}