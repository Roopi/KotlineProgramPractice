package com.ust.myapplication

import java.util.*
import java.lang.*

fun main() {
    var input = listOf(7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9)
    val index = 3


    var inputString = "roopa bai"

    val frequestMap = topFrequentChar(inputString, index, ::UtilTopElem)
    println("$frequestMap")
}

fun UtilTopElem(input: String ,index: Int): Map<Char,Int>{
    var numCountMap = mutableMapOf<Char, Int>()
    for (ele in input){
        numCountMap[ele] = numCountMap.getOrDefault(ele,0) +1
    }
    val listMap = numCountMap.toList()
    println("$listMap")
    val sortedListMap = listMap.sortedByDescending{it.second}
    println("$sortedListMap")
    val takeUpto = sortedListMap.take(index)
    println("$takeUpto")
    val finalMap = takeUpto.toMap()
    println("$finalMap")
    return finalMap

}

fun topFrequentChar(input: String,
                    topIndex: Int,
                    logic: (String, Int) ->Map<Char,Int>
): Map<Char, Int>{
    return logic(input, topIndex)
}

fun topfrequent( numbers: List<Int>,
                 topIndex : Int,
                 logic: (List<Int>, Int)-> Map<Int, Int>
): Map<Int, Int>{
    return logic(numbers, topIndex)
}