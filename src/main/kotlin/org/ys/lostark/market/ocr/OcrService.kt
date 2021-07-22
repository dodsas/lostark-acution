package org.ys.lostark.market.ocr

import net.sourceforge.tess4j.ITessAPI
import net.sourceforge.tess4j.Tesseract
import nu.pattern.OpenCV
import org.opencv.core.Core
import org.opencv.core.Mat
import org.opencv.core.Scalar
import org.opencv.imgcodecs.Imgcodecs
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service
import org.ys.lostark.market.item.Item
import java.io.File
import kotlin.streams.toList


@Service
class OcrService {

    companion object {
        val tesseract: Tesseract = Tesseract()
        val ITEM_OCR_PRESET_MAP: MutableMap<Int, List<Item>> = mutableMapOf()
        init {
            // Tess4j
            val resource = ClassPathResource("tessdata")
            tesseract.setOcrEngineMode(ITessAPI.TessOcrEngineMode.OEM_LSTM_ONLY)
            tesseract.setDatapath(resource.file.absolutePath)
            // https://github.com/Shreeshrii/tessdata_shreetest
            tesseract.setLanguage("digits")
            tesseract.setTessVariable("user_defined_dpi", "300")

            // OpenCV
            OpenCV.loadLocally()

            // Market Preset
            val marketOcrPreset = OcrPreset()
            ITEM_OCR_PRESET_MAP[1] = marketOcrPreset.getPreset()
            ITEM_OCR_PRESET_MAP[2] = marketOcrPreset.getPreset()
            ITEM_OCR_PRESET_MAP[3] = marketOcrPreset.getPreset()
            ITEM_OCR_PRESET_MAP[4] = marketOcrPreset.getPreset()
        }
    }

    fun getMarketListByOcr(imageName: String) : List<Item> {
        val outputPath = binarization(imageName)
        val file = File(outputPath)

        var results = tesseract.doOCR(file).split("\n").toMutableList()
        results = results.stream().filter { c -> c != "" }.toList().toMutableList()

        // OCR 순수 파싱값 로그
        //println(results)

        val marketOcrPreset = ITEM_OCR_PRESET_MAP[imageName.toInt()]!!

        if(marketOcrPreset.size > results.size){
            throw RuntimeException("Invalid Market OCR size (preset = ${marketOcrPreset.size}) (ocr = ${results.size})")
        }

        val list = mutableListOf<Item>()
        for(i in marketOcrPreset.indices){
            val splitString = results[i].split(" ")
            val market = marketOcrPreset[i].clone()
            market.init(splitString[1].toDouble(), splitString[2].toDouble())
            println(market)
            list.add(market)
        }

        return list
    }

    private fun binarization(imageName:String) : String {
        // 색필터
        var frame: Mat = Imgcodecs.imread("E:/tessdata/${imageName}.png")
        var dst: Mat = Mat()
        Core.inRange(frame, Scalar(150.0, 150.0, 150.0), Scalar(255.0, 255.0, 255.0), dst)

        // 색반전
        Core.bitwise_not(dst, dst)

        // 저장
        val outputPath = "E:/tessdata/${imageName}_inverse.png"
        Imgcodecs.imwrite(outputPath, dst)

        return outputPath
    }
}