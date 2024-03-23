package ghar.learn.algorithms.misc

import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.floor


var add: Int = 0
var updated: Int = 0

fun main(array: Array<String>){

      /** Map Operations */
//    val hMap : HashMap<String, String> = hashMapOf(
//        "uu1-xyz" to "abc_zzc",
//        "key-032_03" to "al*2db",)

//    mapAddValue(hMap,"uu1-xyz", "value 1")
//    mapUpdateValue(hMap,"uu2-xyz", "value-10")
//    mapAddValue(hMap,"xyz", "value 2")
//    mapUpdateValue(hMap,"xyz", "value-20")
//    mapUpdateValue(hMap,"key-032_03", "b2**lk<")
//    mapGetValue(hMap,"key-032_03")          // get: total 04 calls
//
//    println("latest map:")
//    hMap.forEach { (k, v) ->
//        println("$k:    $v")
//    }

    println("\n\n2. Sliding Median Window")
    println("-----------------------------")
    // Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//    val input = intArrayOf(3, 1,3,-1,-3,5,3,6,7)
    val input = intArrayOf(3, 1,2,3,4,2,3,1,4,2)
    val window = 3
//    println("Call to slidingWindowMedian(): ${slidingWindowMedian(input).toList()} ")
//    println("Call to slidingWindowMedian(): ${medianSlidingWindow(intArrayOf(1,2,3,4,2,3,1,4,2),


    println("Call to slidingWindowMedian(): ${medianSlidingWindow(intArrayOf(1,3,-1,-3,5,3,6,7), 3).toList()}")
//    println("Call to slidingWindowMedian(): ${medianSlidingWindow(intArrayOf(1,4,2,3), 4).toList()} ")


}


fun mapAddValue(hMap : HashMap<String, String>, k: String, v: String) {
    if (!hMap.containsKey(k)) {
        hMap[k] = v
        println("No.${++add}:  value added")
    }
    else mapUpdateValue(hMap,k, v)
}

fun mapUpdateValue(hMap:HashMap<String, String>, k: String, v: String) {
        if(hMap.containsKey(k)){
            hMap.put(k, v)
            updated++
            println("No.$updated: map updated with key: $k")
        } else {
            mapAddValue(hMap,k, v)
        }
}
fun mapGetValue(hMap:HashMap<String, String>, k: String) : String? {
        if(hMap.containsKey(k)){
            return hMap[k] as String
        } else {
            println("\n'$k' key doesn't exist\n")
        }
    return null
}

//fun slidingWindowMedian(input : IntArray) : DoubleArray {
fun slidingWindowMedian(input : IntArray) : IntArray {

    // 1. index 0 is the window
    val win = input[0]

    // 2. Iterate the input-array from index:1 to End, for
    // a. copy at every iteration the windwo to a 'p:PriorityQueue'
    // b. call on each iteration the calculateMedian(p, win)
    // c. assign the result of step: b to input[

    // input with index:0 being the window:
    // input = (3, 1,3,-1,-3,5,3,6,7)


    for(i in 1 until input.size) {
        val toMedian = IntArray(win)
        for(c in 0 until  win){
            if(i + c <= input.size-1)
            toMedian[c] = input[i + c]
        }
        toMedian.sort()
        input[i] = calculateMedian(toMedian, win)
    }

    return input

}


fun calculateMedian(r: IntArray, win: Int) : Int{

    var median = 0
    median = if(r.size %2 != 0){
        r[(win - 1)/2]
    } else {
        (r[(win/2)-1] + r[win/2])/2
    }
    return median
}

//---------------- From Leet Code: 480
// My solution:

fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
    if(nums.size == 1) return doubleArrayOf(nums[0].toDouble())

    val temp = DoubleArray(nums.size-2)
    val toMedian = DoubleArray(k)
    if(k == nums.size) {
        for(c in 0 until k ) {
            toMedian[c] = nums[c].toDouble()
        }
        toMedian.sort()
        return doubleArrayOf(calculateMedianLeet(toMedian, k))
    }
    else {
        for (i in 1 until nums.size - 1) {
            for (c in 0 until k) {
                if (i + c <= nums.size)
                    toMedian[c] = nums[i + c - 1].toDouble()
            }
            toMedian.sort()
            temp[i - 1] = calculateMedianLeet(toMedian, k)
        }
    }

    return temp
}

fun calculateMedianLeet(r: DoubleArray, win: Int) : Double {
    var median = 0.0
    median = if(r.size %2 != 0) {
        r[(win - 1)/2].toDouble()
    } else {
        (r[(win/2) - 1] + r[win/2]).toDouble() / 2.0
    }
    return median

}
