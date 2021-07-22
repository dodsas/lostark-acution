package org.ys.lostark.market.receipt

import org.ys.lostark.market.item.Item

class Receipt (
    private val inputs : List<ReceiptItem>,
    private val output : ReceiptItem,
    private val baseCost : Double,
    private val spendPoint : Double
) {

    var cost = 0.0
    var revenue = 0.0
    var rate = 0.0
    
    fun print(){
        println("=======================================================")
        for(input: ReceiptItem in inputs) {
            println(input)
        }
        println("-------------------------------------------------------")
        println(output)
        println("-------------------------------------------------------")
        println(String.format("cost    : %7.2f (%7.2f)" , cost, cost*30))
//        println(String.format("revenue : %7.2f (%7.2f) 활동력 1당 %.2f" , revenue, revenue*30, rate))
        println(String.format("revenue : %7.2f (%7.2f)" , revenue, revenue*30))
        println(String.format("rate    : %7.2f (Point:%.0f)", rate, spendPoint))
        println("=======================================================")
    }

    fun link(itemList: List<Item>) {
        for (receiptItem: ReceiptItem in inputs){
            receiptItem.link(itemList)
        }
        output.link(itemList)

        calculate()
    }

    private fun calculate(){
        cost = baseCost
        for (receiptItem: ReceiptItem in inputs) {
            cost += receiptItem.calculateCost()
        }
        revenue = output.getSellPrice() - cost
        rate = revenue / spendPoint
    }
}