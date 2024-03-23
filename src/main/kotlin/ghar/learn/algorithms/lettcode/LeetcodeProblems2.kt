package ghar.learn.algorithms.lettcode

import java.lang.StringBuilder

fun main() {
    println("second file for Leetcode samples")

    val input = intArrayOf(1,1,1,2,2,2,2,3)
//    val input = intArrayOf(0,0,1,1,1,1,2,3,3)
//    val input = intArrayOf(0,0,0,1,1,2,3)

    println("input array: ${input.toList()}")
    println("removedup2() response: ${removeDup2(input)}")

    val c = 4
    var t = 1
    for (i in 1..c) {
        t *=i
    }
    println("factorial of $c: $t")

//    println("majority element: ${findMajorityElement(input)}")

    // Inputs:
//     intArrayOf(1,2,3,4,5,6,7), k = 3
//    val input = intArrayOf(1,2,3,4,5,6,7)
//    val input = intArrayOf(-1)
//    val input = intArrayOf(-1, 2)
//    println("majority element input: ${input.asList()}")
//    println("majority element output: ${rotateArray(input, 3).asList()}")

//    val input = intArrayOf(1,2,3,4,5,6,7)
//    val input = intArrayOf(1,8,6,2,5,4,8,3,7)
//    val input = intArrayOf(1,1)
//    println("maximum area for water container:  ${maxArea(input)}")

    // Reverse words
//    println("Reversed sentense: ${reverseWords("how         are you")}")

    // Best time to sell and Buy
    //Input: prices = [7,1,5,3,6,4]  --> Output: 5
//    val prices = intArrayOf(7,1,5,3,6,4)
//    val prices = intArrayOf(1,2,3,4,5)
    val prices = intArrayOf(7,6,4,3,1)

//    val prices = intArrayOf(7,1,5,3)
//    println("Best profit: ${maxProfit(prices)}")
//    println("Total profit: ${totalProfit(prices)}")


    /** mask vowels with 'x'
    val inputStr = "aeee"
//    val inputStr = "eHee"
//    val inputStr = "eHa"
//    val inputStr = "eHe"
//    val inputStr = "aHe"
//    val inputStr = "ABaLe"
//    val inputStr = "aHLeWae"
        println("masking vowels:\n" )
        println("output string: ${maskVowels(inputStr)}")
     *
     * mask vowels with 'x' ENDS Here
     *
     * */
}

/**
 * Leetcode challenge: 80 [Remove Duplicates from Sorted Array - II]
 * remove the element that appears more than 2-times,
 * Examples:
 * 1. (0,0,1,1,1,2,2,2,2,3) ---> (0,0,1,1,2,2,3), print-count: 7
 */
fun removeDup2(input: IntArray): Int {
    var count = 0
    for (n in input) {
        if ((count < 2) || (n != input[count - 2])
        ) {
            input[count] = n
            count++
        }
    }
    println("output array: ${input.toList()}")
    return count
}

/**
 * Leetcode challenge 169: Majority Element | Leetcode
 * search for array elements that are > n/2
 * where 'n' is length of the array
 *
 * Approach: Moore's Voting algorithm
 */
fun findMajorityElement(nums: IntArray): Int {

    var count = 0
    var element = 0

    for (i in nums.indices) {
        if (count == 0) {
            element = nums[i]
        }
        if (element == nums[i]) {
            count++                         // entry count increased,
        }
        count--                             // entry count decreased
    }
    return element

}

/**
 * Leetcode 189 | Rotate Array
 * by offset of 'k', as per example:
 * 1.
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 *
 * 2.
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 *
 */
fun rotateArray(nums: IntArray, k: Int): IntArray {
    var K = k
    val len = nums.size

    if (k == 0 || len == 1) {
        return nums
    }
    if (k > len) {
        K = k % len
    }
    nums.reverse(0, len)
    nums.reverse(0, K)
    nums.reverse(K, len)

    val mx = Integer.MAX_VALUE
    nums.forEachIndexed { index, i ->
        println("index: $index, element: $i")
    }

    return nums
}

/**
 * Leetcode  11 | Container With Most Water
 *
 */
fun largestWaterContainer(height: IntArray): Int {
    var a = 0
    var b = height.size - 1
    var area_max = 0

    while (a < b) {
        if (height[a] < height[b]) {
            area_max = Math.max(area_max, height[a] * (b - a))
            a++
        } else {
            area_max = Math.max(area_max, height[b] * (b - a))
            b--
        }
    }
    return area_max
}

/**
 * Leetcode 151 | Reverse Words in a String
 * and remove any attached 'additional' spaces with only one provided
 * in the solution
 */

fun reverseWords(s : String) : String {

    println("input string: $s")
    val sSpaceRemoved = s.replace("\\p{Zs}+".toRegex(), " ")
    val toStringArray = sSpaceRemoved.split(" ").toTypedArray()
    val sb = StringBuilder()

    for(i in (toStringArray.size - 1).downTo(0)){
        sb.append(toStringArray[i]).also {
            it.append(" ")
        }
    }
    return sb.toString().trim()
}

/**
 * Leetcode 121 | Best Time to Buy and Sell Stock
 *
 */
fun maxProfit(prices: IntArray): Int {

    var maxP = 0
    var b = 0
    var s = 1
    while(s < prices.size) {
        if(prices[b] < prices[s]){
            val p = prices[s] - prices[b]
            maxP = Math.max(maxP, p)
        }else {
            b++
        }
        s++
    }
    return maxP
}

/**
 * Leetcode 122 | Best Time to Buy and Sell Stock II
 *
 */
fun totalProfit(prices: IntArray): Int {
    var totalP = 0
    var b= 0
    var s = 1

    while(s < prices.size) {
        if(prices[b] < prices[s]){
            totalP += prices[s] - prices[b]
            b++
        }else {
            b++
        }
        s++
    }
    return totalP
}


/**
 * Masks all Vowels with equivalent ascii code, such that
 *
 * x insertions = (ascii-value - 96) * 'x'
 *
 *  e.g:
 *  input: str = 'aebi'
 *  output: 'xxxxxxbxxxxxxxxx'
 *
 *  where net vowels weightage:
 *  'a' ----> 97 - 96   ------> 1    (1 x)
 *  'e' ----> 101 - 96  ------> 5    (5 x)
 *  'a' ----> 105 - 96  ------> 9    (9 x)
 */

fun maskVowels(str: String): String? {
    val inputAsList: MutableList<String> = mutableListOf()
    str.forEach { ch -> inputAsList.add(ch.toString()) }

    println("input string: $str")
    println("------------------------")
    return processStingInfo(inputAsList)
}
fun processStingInfo(inputToList: MutableList<String>) : String {
    inputToList.toMutableList().forEachIndexed { index, s ->
        when(s == "a"|| s == "e" || s == "i" || s == "o" || s == "u") {
            true -> masking(s, inputToList, index)
            else -> {}
        }
    }
    return inputToList.joinToString().replace(",\\p{Zs}".toRegex(), "")
}
private fun masking(s: String, inputToList: MutableList<String>, index: Int) {
    val replacement = mutableListOf<String>()
    (s.toCharArray()[0].code - 96).apply {
        var replacementLen = this
        while (replacementLen > 0) {
            replacement.add("x")
            replacementLen--
        }
    }
    inputToList.removeAt(index)
    inputToList.add(index,
        replacement.joinToString().replace(",\\p{Zs}".toRegex(), "")
    )

}
