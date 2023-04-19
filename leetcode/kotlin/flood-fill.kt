data class Cell(val row: Int, val col: Int)

class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val visited = mutableSetOf<Cell>()
        var islands = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                val cell = Cell(i, j)
                if (grid[i][j] == '1' && !visited.contains(cell)) {
                    bfs(cell, grid, visited)
                    islands++
                }
            }
        }
        return islands
    }

    private fun bfs(start: Cell, grid: Array<CharArray>, visited: MutableSet<Cell>) {
        val frontier = ArrayDeque<Cell>(listOf(start))
        while (frontier.isNotEmpty()) {
            val cell = frontier.removeFirst()
            visited.add(cell)
            val validNeighbors = getNeighbors(cell, grid.size, grid[0].size).filter { 
                cell -> !visited.contains(cell) && grid[cell.row][cell.col] == '1'
            }
            frontier.addAll(validNeighbors)
        }
    }

    private fun getNeighbors(cell: Cell, maxRow: Int, maxCol: Int): List<Cell> {
        val neighbors = mutableListOf<Cell>()
        val row = cell.row
        val col = cell.col
        if (row > 0) {
            neighbors.add(Cell(row - 1, col))
        }
        if (row < maxRow - 1) {
            neighbors.add(Cell(row + 1, col))
        }
        if (col > 0) {
            neighbors.add(Cell(row, col - 1))
        }
        if (col < maxCol - 1) {
            neighbors.add(Cell(row, col + 1))
        }
        return neighbors.toList()
    }
}
