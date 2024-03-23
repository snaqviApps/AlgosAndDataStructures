package ghar.learn.algorithms

import ghar.learn.algorithms.misc.BasicAlgoSamplesOne

fun main(args: Array<String>) {
    println("This app show misc. algorithms")

    /** Sample no# 1 */
    val inputArray = arrayOf(0,1,1,1,0,1,1,0,1,1,-1)
    BasicAlgoSamplesOne.pushAllZerosInTheBack(inputArray)
//
//
//    /** Sorting using QuickSort */
//    val arrayIn = intArrayOf(0, 17, 3, 18, 14, 2, 11, 6)
//    QuickSorting.quickSort(arrayIn, 0, arrayIn.size - 1)
//    println("sorted array using QuickSort: ${arrayIn.contentToString()}")

    /** find a subString */
    val str = charArrayOf('c', 'd', 'e')
    val strCount = BasicAlgoSamplesOne
        .substringOptimized("abcdefehcdef".toCharArray(), str)
    println("\noccurrences of substring: 'str': $strCount")

}
