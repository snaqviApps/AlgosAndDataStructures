package ghar.learn.algorithms.misc

import java.lang.IllegalArgumentException


fun main() {

    val nums_found = twoSum(intArrayOf(4, 8, 11, 15), 15)
    println("did it find: ${nums_found.asList()}")

    println("is Palindrome: ${isPalidrome("radar")}")

}


fun twoSum(nums: IntArray, target: Int ): IntArray {

      val mapOut= mutableMapOf<Int, Int>()

      for (i in nums.indices) {

          // complement:
          val complement = target - nums[i]

          // check if complement exists in the map
          if(mapOut.containsKey(complement)) {

              // if yes, return complement n current number
              return intArrayOf(mapOut[complement]!!, i)
          }

          // if complement doesn't exist in the map, add the current num and its index to the map
          mapOut[nums[i]] = i
      }
        throw IllegalArgumentException("No two elements to add up to the target")
  }

fun isPalidrome(str: String):Boolean {
    var result : Boolean = true
    val len = str.length

    for(i in len - 1 downTo 0) {
        if (str[i] != str[len - 1 - i])
            result = false
            break
    }
    return result
}