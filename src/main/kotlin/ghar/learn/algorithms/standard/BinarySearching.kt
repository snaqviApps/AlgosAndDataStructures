package ghar.learn.algorithms.standard


fun main(args: Array<String>) {

    // Binary search
    val array = arrayListOf(1, 5, 15, 17, 19, 22, 24, 31, 105, 150)
    val search24 = array.indexOf(24)
    val binarySearch31 = array.binarySearches(24)

    println("indexOf(): $search24")
    println("index for: binary-search result of binSearchResult: $binarySearch31")
}

// 1
// It expects a 'sorted' input
fun <T: Comparable<T>> ArrayList<T>.binarySearches(
    value: T,
    range: IntRange = indices           // 2
): Int? {

    if (range.first > range.last) {                        // 1
        return null
    }

    val size = range.last - range.first + 1           // 2
    val middle = range.first + size / 2
    return when {
        this[middle] == value -> middle                    // 3
        // 4
        this[middle] > value -> binarySearches(value, range.first until  middle)      // right
        else -> binarySearches(value, (middle + 1)..range.last)
    }

}