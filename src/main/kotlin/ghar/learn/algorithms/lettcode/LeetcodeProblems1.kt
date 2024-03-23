package ghar.learn.algorithms.lettcode

import kotlin.math.abs


fun main() {

/**
 * Merge sorted arrays sample inputs:
 * 1. nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 2. nums1 = [1], m = 1, nums2 = [], n = 0
 * 3. nums1 = [0], m = 0, nums2 = [1], n = 1
 *  */

//    merge(intArrayOf(0), 0,
//    intArrayOf(1), 1
//    )

    merge(intArrayOf(0), 0,
    intArrayOf(1), 1
    )



//    removeElements(intArrayOf(3,2,2,0,1), 2).also {
//        println("removed count: $it")
//    }

//    println(" ${removeDup(intArrayOf(0,0,1,1,1,2,2,3,3,4))}")

/**
 * LeetCode# 219: remove duplicates with a condition
 * sample input: (0,0,1,1,1), k = 1 --> true
 * sample input: (1,2,3,1) , k = 3  ---> true
 * sample input: (1,0,1,1)   k = 1  ---> true
 *
 * println(" ${removeDup2(intArrayOf(1,2,2,3,1,2,3), 2)}")           // false
 *
 * */

}

/**
 * Leetcode 88 | Merge Sorted Array
 *
 */
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {

    println("input array1: ${nums1.asList()}")
    println("input array2: ${nums2.asList()}")

    var k = m + n - 1  // index for nums1 -> nums1.size - 1
    var i = m - 1  // index for nums1
    var j = n - 1 // index for nums2

    while (j >= 0) {
        nums1[k--] = if((i >= 0) && (nums2[j] <= nums1[i]))
        {
            nums1[i--]
        } else {
            nums2[j--]
        }
    }
    println("result: ${nums1.toList()}")
}


/**
 * LeetCode problem 26
 *  removes the duplicates elements from non-decreasing-array (sorted, low-to-high)
 *  and return the counts of unique (non-duplicating) elements
 */
fun removeDup(nums: IntArray): Int {

    println("input array: ${nums.asList()}")
    var count = 0;
    for (i in nums.indices) {

        /**
         * Last Index is automatically be non-duplicate, so verification is not added
         */
        if ((i < nums.size - 1) && nums[i] == nums[i + 1]) {
            continue
        }
        else {
            nums[count++] = nums[i]
        }
    }
    println("modified array: ${nums.toList()}")
    return count
}

/**
 * LeetCode# 219
 * find duplicate if two indices contain the same values,
 * however, the indices difference should be as below:
 *  abs(i - j) <= k
 *  where 'k' is the value to be tested
 */
//fun removeDup2(nums: IntArray, k: Int) : Boolean {
fun removeDup2(nums: IntArray, k: Int) : Boolean {

    /** We would apply hash-map: keys for saving the indices values */
    val hashMap = HashMap<Int, Int>()

    for (i in nums.indices) {
        if(!hashMap.containsKey(nums[i])) {
            hashMap.put(nums[i], i)
        } else {
            val pastIndex = hashMap[nums[i]]?.minus(i)?.let { abs(it) }
            if(pastIndex!! <= k) {
                return true
            } else {
                hashMap[nums[i]] = i
            }
        }
    }

    return false

}
