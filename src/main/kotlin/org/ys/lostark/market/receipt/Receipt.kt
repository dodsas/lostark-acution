package org.ys.lostark.market.receipt

import org.springframework.util.ResourceUtils
import org.ys.lostark.market.Market
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.lang.StringBuilder

class Receipt (
    val inputs : List<ReceiptItem>,
    val output : ReceiptItem
) {

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("------------------------\n")
        for(input: ReceiptItem in inputs) {
            stringBuilder.append(String.format("%-5d %s\n", input.count, input.itemName))
        }
        stringBuilder.append("output -----------------\n")
        stringBuilder.append(String.format("%-5d %s\n", output.count, output.itemName))
        stringBuilder.append("------------------------\n")
        return stringBuilder.toString()
    }
}