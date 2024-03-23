package ghar.learn.algorithms.standard

//open class QuickSorting<T> (val unsortedArray: Array<T>) {
class QuickSorting {

    companion object {
        fun quickSort(unsortedArray: IntArray, small: Int, large: Int) {
            if (small < large) {
                val pivot = partition(unsortedArray, small, large)
                quickSort(unsortedArray, small, pivot - 1)          // entries smaller than pivot
                quickSort(unsortedArray, pivot + 1, large)          // entries larger than pivot
            }
        }

        private fun partition(inputArray: IntArray, small: Int, large: Int): Int {

            // this method provides one (out of many ways of) partitioning the two slices of sub-arrays from the input
            val pi = inputArray[large]          // pivot
            var i = small - 1
            for (j in small until large) {
                if (inputArray[j] < pi) {
                    i++
                    swap(inputArray, i, j)
                }
            }
            swap(inputArray, i + 1, large)
            return i + 1
        }

        private fun swap(arr: IntArray, i: Int, j: Int) {
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }

    }
}