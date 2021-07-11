package org.ys.lostark.market.receipt

import org.springframework.stereotype.Service
import org.springframework.util.ResourceUtils
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.lang.RuntimeException

@Service
class ReceiptService {

    private val bufferedReader: BufferedReader
    private val iterator: Iterator<String>

    init {
        val file: File = ResourceUtils.getFile("classpath:preset/receipt.txt")
        bufferedReader = BufferedReader(FileReader(file))
        iterator = bufferedReader.lineSequence().iterator()
    }

    private fun getReceipt() : Receipt  {
        val inputs = mutableListOf<ReceiptItem>()
        var output = ReceiptItem("dummy", 1)

        while(iterator.hasNext()) {
            val line = iterator.next()
            if(line == ""){
                continue
            }
            val split = line.split(",")
            when(split[0]){
                "i" -> inputs.add(ReceiptItem(split[1], split[2].toInt()))
                "o" -> output = ReceiptItem(split[1], split[2].toInt())
                "c" -> {
                    val receipt = Receipt(inputs, output, split[1].toDouble())
                    receipt.print()
                    return receipt
                }
            }
        }
        throw RuntimeException("Invalid receipt.txt")
    }

    fun prepare() : List<Receipt>{
        val receiptList = mutableListOf<Receipt>()
        while (iterator.hasNext()){
            receiptList.add(getReceipt())
        }
        return receiptList
    }
}