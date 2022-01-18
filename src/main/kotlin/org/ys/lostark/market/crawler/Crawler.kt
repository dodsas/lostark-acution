package org.ys.lostark.market.crawler

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
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

        val cookie = "sgs_da_uuid=1ab11ead-9947-4cec-bd7c-db5f7716c08f; sgs_da_session=1ab11ead-9947-4cec-bd7c-db5f7716c08f; _ga=GA1.2.733299075.1580624564; _gcl_au=1.1.27834967.1624185284; _gid=GA1.2.191661996.1632937138; page_uid=7624f438eed53b5fd7febf32c8eff6d0; n_uid=ad3d2c3dc1d8420b83d48e1ef364867f; PRM=KO; NNTO=KR; TZ=Asia/Seoul; TZ_OFFSET=540; COVERAGES=de%2Cen%2Ces%2Cfr%2Cid%2Cit%2Cja%2Cko%2Cpt%2Cth%2Cvi%2Czh%2Czh-tw; LOCALE=KO; sgs_da_session_30=se-a41c9eb8-6ea7-4fbc-aca1-71f2e96ba8ba; SUAT=eyJhbGciOiJIUzI1NiJ9.eyJleHBpcmVfdGltZSI6MTYzMzIwMTMxNTI5NSwibWVtYmVyX25vIjo4MDM1NDk5MywiYXBwbGljYXRpb25fbm8iOjEwMDAyfQ.iqk2f85WUfqnGqQAOg7Kk8FPCTJ8nPcQZET1VTZcEhe08fdhitQZYOMRSvLOBArSiVffnqUQtedrKFN-Y0ROiPMeFeqGDXmLyZNqhp-ePT2FbL8SnZL-79bWbuOaZib0ftDwFKMn_dbVwaoMsr_fGlG9X0jiaUUrZg5Zz2x1GtAVAIJaQ110QiDMg3refTsdAfKo7sr6CoKU8I3-jfaz5nxYp4z09MasJ15Ud1jzABo; HD=eyJhbGciOiJIUzI1NiJ9; PLD=eyJleHBpcmVfdGltZSI6MTYzMzIwMTMxNTI5NSwibWVtYmVyX25vIjo4MDM1NDk5MywiYXBwbGljYXRpb25fbm8iOjEwMDAyfQ; SIGN=iqk2f85WUfqnGqQAOg7Kk8FPCTJ8nPcQZET1VTZcEhe08fdhitQZYOMRSvLOBArSiVffnqUQtedrKFN-Y0ROiPMeFeqGDXmLyZNqhp-ePT2FbL8SnZL-79bWbuOaZib0ftDwFKMn_dbVwaoMsr_fGlG9X0jiaUUrZg5Zz2x1GtAVAIJaQ110QiDMg3refTsdAfKo7sr6CoKU8I3-jfaz5nxYp4z09MasJ15Ud1jzABo; RFT=iqk2f85WUfqnGqQAOg7Kk8FPCTJ8nPcQZET1VTZcEhe08fdhitQZYOMRSvLOBArSdFAEPgsX6LsAoYXPXbvbbLHJ97LyOMMC-3qnJYXesoqDHKmyuy2O68blqO5UwRzLJvnwoP2abstTuJG36Xw5HPjLBr8uWEz-X9pXqDPPpZ44zhriNFOW_G3Cv0gxYIyCHcLkD013DWZZNKz35fZbCH-eQNmiiC-64mBl6bba-rk; SURT=iqk2f85WUfqnGqQAOg7Kk8FPCTJ8nPcQZET1VTZcEhe08fdhitQZYOMRSvLOBArSdFAEPgsX6LsAoYXPXbvbbLHJ97LyOMMC-3qnJYXesoqDHKmyuy2O68blqO5UwRzLJvnwoP2abstTuJG36Xw5HPjLBr8uWEz-X9pXqDPPpZ44zhriNFOW_G3Cv0gxYIyCHcLkD013DWZZNKz35fZbCH-eQNmiiC-64mBl6bba-rk; FOREVER=N"
        val headers = HttpHeaders()
        headers.set("Cookie", cookie)

        val httpEntity = HttpEntity(null, headers)

        println(uriComponents.toUriString())

//        val respString = restTemplate.getForObject(
//            uriComponents.toUriString(),
//            String::class.java
//        )

        val respString = restTemplate.exchange(
            uriComponents.toUriString(),
            HttpMethod.GET,
            httpEntity,
            String::class.java
        )

        return respString.body ?: ""
    }
}