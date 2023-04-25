class Solution {
    data class QueueCell(val matrixCell: MatrixCell, val minute: Int)
    data class MatrixCell(val i: Int, val j: Int)

    fun orangesRotting(grid: Array<IntArray>): Int {
        val frontier = ArrayDeque<QueueCell>()
        var minute = 0
        var freshOranges = 0

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 1) {
                    freshOranges++
                } else if (grid[i][j] == 2) {
                    frontier.add(QueueCell(MatrixCell(i, j), 0))
                }
            }
        }

        while (frontier.isNotEmpty()) {
            val queueCell: QueueCell = frontier.removeFirst()
            
            val cell = queueCell.matrixCell
            val currentMinute = queueCell.minute
            minute = currentMinute
            val neighboors: List<MatrixCell> = getNeighboors(grid, cell.i, cell.j).filter { grid[it.i][it.j] == 1 }
            
            neighboors.forEach {
                freshOranges--
                grid[it.i][it.j] = 2
                frontier.add(QueueCell(it, currentMinute + 1))
            }
        }
        return if (freshOranges == 0) minute else -1
    }

    private fun getNeighboors(grid: Array<IntArray>, i: Int, j: Int): List<MatrixCell> {
        val neighboors = mutableListOf<MatrixCell>()
        if (i >= 1) {
            neighboors.add(MatrixCell(i - 1, j))
        }
        if (i <= grid.size - 2) {
            neighboors.add(MatrixCell(i + 1, j))
        }
        if (j >= 1) {
            neighboors.add(MatrixCell(i, j - 1))
        }
        if (j <= grid[0].size - 2) {
            neighboors.add(MatrixCell(i, j + 1))
        }
        return neighboors.toList()
    }
}