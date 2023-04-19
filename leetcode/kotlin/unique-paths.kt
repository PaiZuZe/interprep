class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val pathsCount = Array<IntArray>(m) { IntArray(n) { 1 } }
        for (i in 1 until m) {
            for (j in 1 until n) {
                pathsCount[i][j] = pathsCount[i - 1][j] + pathsCount[i][j - 1]
            }
        }
        return pathsCount[m - 1][n - 1]
    }
}
