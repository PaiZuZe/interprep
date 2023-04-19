data class Cell(val row: Int, val col: Int)

class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val visited = Array(grid.size) { BooleanArray(grid[0].size) { false } }

        var islands = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                val cell = Cell(i, j)
                if (grid[i][j] == '1' && !visited[cell.row][cell.col]) {
                    bfs(cell, grid, visited)
                    islands++
                }
            }
        }
        return islands
    }

    private fun bfs(start: Cell, grid: Array<CharArray>, visited: Array<BooleanArray>) {
        val frontier = ArrayDeque<Cell>(listOf(start))
        visited[start.row][start.col] = true
        while (frontier.isNotEmpty()) {
            val cell = frontier.removeFirst()
            getNeighbors(cell, grid.size, grid[0].size).filter { 
                neighbor -> !visited[neighbor.row][neighbor.col] && grid[neighbor.row][neighbor.col] == '1'
            }.forEach {
                visited[it.row][it.col] = true 
                frontier.addLast(it) 
            }
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

