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
/*
* top element in a map witinout listOfNumber or string using Map of to check element already
* present in map by call getOrdefault fun takes key element and retruns 0 by default,
* strire it in initialized mutable map of the generic type wuth key eother Int or Char later on
* same map call toList, then sortedByDescending takes lambda for second value in list of numbers,
* on same map call take function which takes number as inout for prefered numbers, and then covert
* retruned data holder to map, to print key value pair
* */
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