package com.ust.mykotlineprograms

class TopFrequentEleWithoutExtraStorage(private val numbers: MutableList<Int>) {

    /** Prints frequency of each distinct number (after in-place sort). */
    fun printFrequencies() {
        if (numbers.isEmpty()) return

        numbers.sort() // in-place

        var i = 0
        while (i < numbers.size) {
            val current = numbers[i]
            var count = 1
            var j = i + 1
            while (j < numbers.size && numbers[j] == current) {
                count++
                j++
            }
            println("$current -> $count")
            i = j // jump to the next distinct element
        }
    }

    /** Returns the most frequent element and its count (mode) without extra storage. */
    fun mode(): Pair<Int, Int> {
        require(numbers.isNotEmpty()) { "List must not be empty" }

        numbers.sort() // in-place

        var bestValue = numbers[0]
        var bestCount = 1

        var i = 0
        while (i < numbers.size) {
            val current = numbers[i]
            var count = 1
            var j = i + 1
            while (j < numbers.size && numbers[j] == current) {
                count++
                j++
            }
            if (count > bestCount) {
                bestCount = count
                bestValue = current
            }
            i = j
        }
        return bestValue to bestCount
    }
}



fun main() {
    val duplicate = mutableListOf(1, 2, 3, 4, 1, 2, 3, 4, 1, 23, 5, 6)
    val topFrequentEle = TopFrequentEleWithoutExtraStorage(duplicate)

    println("Original: $duplicate")
    topFrequentEle.printFrequencies()

    val (value, count) = topFrequentEle.mode()
    println("Mode: $value (count = $count)")

    /** If using extra storage is acceptable, Kotlin makes this trivial and very readable: */
    val counts = duplicate.groupingBy { it }.eachCount()
    val (modeValue, modeCount) = counts.maxByOrNull { it.value }!!
    println(counts)                        // {1=3, 2=2, 3=2, 4=2, 23=1, 5=1, 6=1}
    println("Mode: $modeValue ($modeCount)")
}