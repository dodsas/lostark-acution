package org.ys.lostark.market

import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.ys.lostark.market.item.ItemService

@SpringBootTest
internal class ItemServiceTest {

    @Autowired
    lateinit var itemService: ItemService

    @Test
    fun progress() {
        itemService.progress()
    }
}