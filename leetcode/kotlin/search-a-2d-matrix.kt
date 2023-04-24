class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        return matrixBinarySearch(matrix, target, 0, matrix.size * matrix[0].size)
    }

    private fun matrixBinarySearch(matrix: Array<IntArray>, target: Int, start: Int, end: Int): Boolean {
        println("start: ${ start }, end: ${ end }")
        if (end <= start) {
            return false
        }
        val n = matrix[0].size
        val middle: Int = ((end - start) / 2) + start
        return if (matrix[middle / n][middle % n] == target) {
            true
        } else if (matrix[middle / n][middle % n] > target) {
            matrixBinarySearch(matrix, target, start, middle)
        } else {
            matrixBinarySearch(matrix, target, middle + 1, end)
        }
    }
}