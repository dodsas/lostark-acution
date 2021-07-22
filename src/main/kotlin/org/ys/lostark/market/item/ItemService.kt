package org.ys.lostark.market.item

import org.springframework.stereotype.Service
import org.ys.lostark.market.crawler.CrawlerService
import org.ys.lostark.market.ocr.OcrService

@Service
class ItemService(
    private val crawlerService: CrawlerService,
    private val ocrService: OcrService,
)
{
    fun prepare() : List<Item> {
        val itemList = mutableListOf<Item>()
        itemList.add(crawlerService.getItemInfo("하급 오레하 융화 재료"))
        itemList.add(crawlerService.getItemInfo("회복약"))
        itemList.add(crawlerService.getItemInfo("고급 회복약"))
        itemList.add(crawlerService.getItemInfo("정령의 회복약"))
        itemList.add(crawlerService.getItemInfo("각성 물약"))
        itemList.add(crawlerService.getItemInfo("만능 물약"))
        itemList.add(crawlerService.getItemInfo("보호 물약"))
        itemList.add(crawlerService.getItemInfo("천둥 물약"))
        itemList.add(crawlerService.getItemInfo("아드로핀 물약"))
        itemList.add(crawlerService.getItemInfo("시간 정지 물약"))

        itemList.add(crawlerService.getItemInfo("성스러운 폭탄"))
        itemList.add(crawlerService.getItemInfo("부식 폭탄"))
        itemList.add(crawlerService.getItemInfo("빛나는 부식 폭탄"))
        itemList.add(crawlerService.getItemInfo("수면 폭탄"))
        itemList.add(crawlerService.getItemInfo("파괴 폭탄"))
        itemList.add(crawlerService.getItemInfo("페로몬 폭탄"))

        itemList.add(crawlerService.getItemInfo("섬광 수류탄"))
        itemList.add(crawlerService.getItemInfo("화염 수류탄"))
        itemList.add(crawlerService.getItemInfo("냉기 수류탄"))
        itemList.add(crawlerService.getItemInfo("전기 수류탄"))
        itemList.add(crawlerService.getItemInfo("암흑 수류탄"))
        itemList.add(crawlerService.getItemInfo("회오리 수류탄"))
        itemList.add(crawlerService.getItemInfo("점토 수류탄"))

        itemList.add(crawlerService.getItemInfo("위장 로브"))
        itemList.add(crawlerService.getItemInfo("빛나는 위장 로브"))
        itemList.add(crawlerService.getItemInfo("은신 로브"))
        itemList.add(crawlerService.getItemInfo("빛나는 은신 로브"))
        itemList.add(crawlerService.getItemInfo("신속 로브"))

        itemList.add(crawlerService.getItemInfo("신호탄"))
        itemList.add(crawlerService.getItemInfo("빛나는 신호탄"))
        itemList.add(crawlerService.getItemInfo("도발 허수아비"))
        itemList.add(crawlerService.getItemInfo("모닥불"))
        itemList.add(crawlerService.getItemInfo("진군의 깃발"))
        itemList.add(crawlerService.getItemInfo("성스러운 부적"))
        itemList.add(crawlerService.getItemInfo("빛나는 성스러운 부적"))
        itemList.add(crawlerService.getItemInfo("루테란의 나팔"))
        itemList.add(crawlerService.getItemInfo("정비소 이동 포탈 주문서"))

        itemList.add(crawlerService.getItemInfo("장인의 노릇한 꼬치구이"))
        itemList.add(crawlerService.getItemInfo("장인의 매콤한 스튜"))
        itemList.add(crawlerService.getItemInfo("장인의 폭신한 오믈렛"))
        itemList.add(crawlerService.getItemInfo("달인의 바삭한 꼬치구이"))
        itemList.add(crawlerService.getItemInfo("달인의 달콤한 스튜"))
        itemList.add(crawlerService.getItemInfo("달인의 부드러운 오믈렛"))
        itemList.add(crawlerService.getItemInfo("명인의 쫄깃한 꼬치구이"))
        itemList.add(crawlerService.getItemInfo("명인의 짭짤한 스튜"))
        itemList.add(crawlerService.getItemInfo("명인의 촉촉한 오믈렛"))

        itemList.add(crawlerService.getItemInfo("철광석"))
        itemList.add(crawlerService.getItemInfo("투박한 버섯"))
        itemList.add(crawlerService.getItemInfo("들꽃"))
        itemList.add(crawlerService.getItemInfo("목재"))
        itemList.add(crawlerService.getItemInfo("두툼한 생고기"))
        itemList.add(crawlerService.getItemInfo("고대 유물"))
        itemList.add(crawlerService.getItemInfo("생선"))
        itemList.add(crawlerService.getItemInfo("초보자용 제작 키트"))
        itemList.add(crawlerService.getItemInfo("묵직한 철광석"))
        itemList.add(crawlerService.getItemInfo("붉은 살 생선"))
        itemList.add(crawlerService.getItemInfo("싱싱한 버섯"))
        itemList.add(crawlerService.getItemInfo("수줍은 들꽃"))
        itemList.add(crawlerService.getItemInfo("부드러운 목재"))
        itemList.add(crawlerService.getItemInfo("다듬은 생고기"))
        itemList.add(crawlerService.getItemInfo("자연산 진주"))
        itemList.add(crawlerService.getItemInfo("도구 제작 부품"))
        itemList.add(crawlerService.getItemInfo("질긴 가죽"))
        itemList.add(crawlerService.getItemInfo("희귀한 유물"))
        itemList.add(crawlerService.getItemInfo("칼다르 태양 잉어"))
        itemList.add(crawlerService.getItemInfo("칼다르 유물"))
        itemList.add(crawlerService.getItemInfo("견습생용 제작 키트"))
        itemList.add(crawlerService.getItemInfo("칼다르 두툼한 생고기"))
        itemList.add(crawlerService.getItemInfo("단단한 철광석"))
        itemList.add(crawlerService.getItemInfo("오레하 태양 잉어"))
        itemList.add(crawlerService.getItemInfo("화려한 버섯"))
        itemList.add(crawlerService.getItemInfo("화사한 들꽃"))
        itemList.add(crawlerService.getItemInfo("오레하 유물"))
        itemList.add(crawlerService.getItemInfo("튼튼한 목재"))
        itemList.add(crawlerService.getItemInfo("오레하 두툼한 생고기"))
        itemList.add(crawlerService.getItemInfo("낚시의 결정"))
        itemList.add(crawlerService.getItemInfo("고고학의 결정"))
        itemList.add(crawlerService.getItemInfo("수렵의 결정"))

//        itemList.addAll(ocrService.getMarketListByOcr("1"))
//        itemList.addAll(ocrService.getMarketListByOcr("2"))
//        itemList.addAll(ocrService.getMarketListByOcr("3"))
//        itemList.addAll(ocrService.getMarketListByOcr("4"))
        return itemList
    }
}