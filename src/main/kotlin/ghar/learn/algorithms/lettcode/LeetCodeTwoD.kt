package ghar.learn.algorithms.lettcode

fun main(array: Array<String>){

    println("4th Leetcode attempt")
    println("----------------------------")

    /** Rotate matrix by 90 degrees */
    val matrix = arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(4,5,6),
        intArrayOf(7,8,9)
    )
//     println("matrix length: ${matrix.size}")
//     rotate(matrix)
    /** Rotate matrix by 90 degrees ENDS */

    /** Jump Game */
    val input = intArrayOf(3,2,1,0,4)
//    val input = intArrayOf(2,3,1,1,4)
    println("can jump: ${canJump(input)}")
    /** Jump Game ENDS */

}

fun rotate(matrix: Array<IntArray>) {

    val r = matrix.size

    for(i in 0 until r) {
        println("pre-rotation: matrix rows: ${matrix[i].toList()}")
        for(j in 0.. i) {
            val temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
        }
    }

    for(i in 0 until r) {
        matrix[i].reverse()
    }

    println("-----------------------")
    for(i in 0 until r){
        println("post-rotation: matrix rows: ${matrix[i].toList()}")
    }

}


/**
 * Leetcode: 55 | jump game
 */
fun canJump(nums: IntArray): Boolean {

    val size = nums.size
    var lastPosition = nums.size - 1

    for (i in (size - 1) downTo 0) {
        if (i + nums[i] >= lastPosition) {
            lastPosition = i
        }
    }
    return lastPosition == 0
}

