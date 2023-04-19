class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val resp = mutableListOf<Int>()
        spiralOrder(matrix, 0, 0, matrix.size, matrix[0].size, resp)
        return resp.toList()
    }

    private fun spiralOrder(matrix: Array<IntArray>, rowStart: Int, colStart: Int, maxRow: Int, maxCol: Int, resp: MutableList<Int>) {
        if (rowStart >= maxRow || colStart >= maxCol) {
            return
        }
        for (j in colStart until maxCol) {
            resp.add(matrix[rowStart][j])
        }
        for (i in rowStart + 1 until maxRow) {
            resp.add(matrix[i][maxCol - 1])
        }
        if (maxRow - 1 != rowStart) {
            for (j in maxCol - 2 downTo colStart) {
                resp.add(matrix[maxRow - 1][j])
            }
        }
        if (maxCol - 1 != colStart) {
            for (i in maxRow - 2 downTo rowStart + 1) {
                resp.add(matrix[i][colStart])
            }
        }
        spiralOrder(matrix, rowStart + 1, colStart + 1, maxRow - 1, maxCol - 1, resp)
    }
}
