package ghar.learn.algorithms.misc

class BasicAlgoSamplesOne {

    companion object {

    /**
     * Sample Algorithm: 01
     *
     * This method takes an input array that info in terms of Zeros and Ones, such that:
     *
     * Zero: represents an 'Empty' Box
     * One: represents an 'Filled' Box
     * Target: to push all filled-boxs (1s) to the 'front' and Empty-boxes at the rear
     * sample input ------> expected outputs, as below:
     *  t = [1,1,1,0,1,1,0,1,1,0] ----> [1,1,1,1,1,1,1,0,0,0]
     *  t = [1,1,1,0,1,1,0,1,1,-1] ---->  [1,1,1,1,1,1,1,0,0]
     */

    fun pushAllZerosInTheBack(inputArray: Array<Int>) {
        println("-----------------")
        println("this call pushes all input array's zeros to the end of the array:")
        println("input array: ${inputArray.toList()}")
        val tempOnesFound = mutableListOf<Int>()
        val tResultTempInvalid = mutableListOf<Int>()
        val tempZerosFound = mutableListOf<Int>()
        for (i in inputArray) {
            when (i) {
                0 -> tempZerosFound.add(0)
                1 -> tempOnesFound.add(i)
                else -> {
                    tResultTempInvalid.plus(-1)
                }
            }
        }
        tempOnesFound.addAll(tempZerosFound)
        println("output-array: ${tempOnesFound.toList()}")
        println("-----------------")

    }

    /**
     * O(m + n), where m = str.size, and n = substr.size
     *
     * This function uses a deterministic finite automation (DFA) method
     * which entails the use of a state machine to keep track of progress
     * in a game.
     */
    fun substringOptimized (
        inputStr: CharArray,
        subStr: CharArray
    ): Int {
        class StateMachine(val pattern: CharArray) {
            var cursor: Int = 0
            fun add(ch: Char) {
                if (pattern[cursor] == ch) {
                    cursor++
                }
                else cursor = 0
            }
            fun isMatch(): Boolean {
                return cursor == pattern.size
            }
            fun reset() {
                cursor = 0
            }
        }

        val stateMachine = StateMachine(subStr)
        var numberOfOccurrences = 0
//        for (cursor in 0 until str.size) {
        for (element in inputStr) {    // same as above
            stateMachine.add(element)
            if (stateMachine.isMatch()) {
                stateMachine.reset()
                numberOfOccurrences++
            }
        }
        return numberOfOccurrences
    }

}

}