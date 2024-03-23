package ghar.learn.algorithms.lettcode

fun main(args: Array<String>){
    println("Leetcode 134 onwards, i.e: 134. Gas station")
    println("---------------------")

    /**
     * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
     */
    println("gas station number 'gas[i]: " +
            "${canCompleteCircuit(intArrayOf(1, 2, 3, 4, 5), intArrayOf(3, 4, 5, 1, 2))}"
//            "${canCompleteCircuit(intArrayOf(2,3,4), intArrayOf(3,4,3))}"
    )
}

/**
 * Leetcode | 134: Gas Station
 *
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 *
 */

fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {

    var tGas = 0
    var iGas = 0
    var start = 0

    for(i in gas.indices) {
        tGas += gas[i] -cost[i]
        iGas += gas[i] - cost[i]
        if(iGas < 0) {
            iGas = 0
            start = i + 1
        }
    }

    return if(tGas >= 0) start else -1
}



