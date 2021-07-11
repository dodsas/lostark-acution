package org.ys.lostark.market.ocr

import org.springframework.util.ResourceUtils
import org.ys.lostark.market.Market
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class MarketOcrPreset {

    private val bufferedReader: BufferedReader
    private val iterator: Iterator<String>

    init {
        val file: File = ResourceUtils.getFile("classpath:preset/marketItemList.txt")
        bufferedReader = BufferedReader(FileReader(file))
        iterator = bufferedReader.lineSequence().iterator()
    }

    fun getPreset() : List<Market> {
        val list = mutableListOf<Market>()
        var count = 0
        while(iterator.hasNext() && count < 10) {
            val line = iterator.next()
            if(line == ""){
                continue
            }
            count++
            val split = line.split(",")
            list.add(Market(split[0], split[1].toInt()))
        }
        return list
    }
}

//enum class MarketOcrPreset(val itemList: List<Market>) {
//    `1`(listOf(
//        Market("철광석", 100),
//        Market("투박한 버섯", 100),
//        Market("들꽃", 100),
//        Market("목재", 100),
//        Market("두툼한 생고기", 100),
//        Market("고대 유물", 100),
//        Market("생선", 100),
//        Market("초보자용 제작 키트",1),
//        Market("묵직한 철광석", 10),
//        Market("부드러운 목재", 10)
//    )),
//    `2`(listOf(
//        Market("싱싱한 버섯",10),
//        Market("수줍은 들꽃",10),
//        Market("붉은 살 생선" ,10),
//        Market("다듬은 생고기",10),
//        Market("자연산 진주",10),
//        Market("도구 제작 부품",1),
//        Market("질긴 가죽",10),
//        Market("희귀한 유물",10),
//        Market("칼다르 태양 잉어",10),
//        Market("견습생용 제작 키트", 1)
//    )),
//    `3`(listOf(
//        Market("칼다르 유물",10),
//        Market("단단한 철광석",10),
//        Market("칼다르 두툼한 생고기",10),
//        Market("오레하 태양 잉어",10),
//        Market("화려한 버섯",10),
//        Market("화사한 들꽃",10),
//        Market("튼튼한 목재",10),
//        Market("오레하 유물",10),
//        Market("오레하 두툼한 생고기",10),
//        Market("낚시의 결정", 10)
//    )),
//    `4`(listOf(
//        Market("고고학의 결정",10),
//        Market("수렵의 결정",10),
//        Market("숙련가용 제작 키트",1),
//        Market("전문가용 제작 키트",1),
//        Market("달인용 제작 키트", 1)
//    ));
//}