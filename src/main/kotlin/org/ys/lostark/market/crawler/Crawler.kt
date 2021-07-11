package org.ys.lostark.market.crawler

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder


@Service
class Crawler(
    private val restTemplate: RestTemplate
) {
    fun getItemValue(itemName: String): String {

        val uriComponents = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host("lostark.game.onstove.com")
            .path("/Market/List_v2")
            .queryParam("itemName", itemName)
            .queryParam("isInit", false)
            .build()

        println(uriComponents.toUriString())

        val respString = restTemplate.getForObject(
            uriComponents.toUriString(),
            String::class.java
        )

        return respString ?: ""
    }
}