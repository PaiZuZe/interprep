class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val resp = mutableListOf<List<Int>>()
        val visitsPacific = Array(heights.size) { BooleanArray(heights[0].size) { false } }
        val visitsAtlantic = Array(heights.size) { BooleanArray(heights[0].size) { false } }
        val pacificBorder = List(heights[0].size) { listOf(0, it) } + 
            List(heights.size) { listOf(it, 0) }
        val atlanticBorder = List(heights[0].size) { listOf(heights.size - 1, it) } + 
            List(heights.size) { listOf(it, heights[0].size - 1) }

        
        bfs(heights, pacificBorder, visitsPacific)
        bfs(heights, atlanticBorder, visitsAtlantic)
        for (i in heights.indices) {
            for (j in heights[0].indices) {
                if (visitsAtlantic[i][j] && visitsPacific[i][j]) {
                    resp.add(listOf(i, j))
                }
            }
        }
        return resp.toList()
    }

    private fun bfs(heights: Array<IntArray>, oceanBorder: List<List<Int>> , visitsOcean: Array<BooleanArray>) {
        val frontier = ArrayDeque<List<Int>>(oceanBorder)
        oceanBorder.forEach { visitsOcean[it[0]][it[1]] = true }
        
        while (frontier.isNotEmpty()) {
            val cell = frontier.removeFirst()
            getNeighboors(heights, cell[0], cell[1])
                .filter { neighboor -> !visitsOcean[neighboor[0]][neighboor[1]] }
                .forEach { neighboor ->
                    visitsOcean[neighboor[0]][neighboor[1]] = true
                    frontier.add(neighboor)
                }
        }
    }

    private fun getNeighboors(heights: Array<IntArray>, i: Int, j: Int): List<List<Int>> {
        val neighboors = mutableListOf<List<Int>>()
        if (i >= 1 && heights[i][j] <= heights[i - 1][j]) {
            neighboors.add(listOf<Int>(i - 1, j))
        }
        if (i <= heights.size - 2 && heights[i][j] <= heights[i + 1][j]) {
            neighboors.add(listOf<Int>(i + 1, j))
        }
        if (j >= 1 && heights[i][j] <= heights[i][j - 1]) {
            neighboors.add(listOf<Int>(i, j - 1))
        }
        if (j <= heights[0].size - 2 && heights[i][j] <= heights[i][j + 1]) {
            neighboors.add(listOf<Int>(i, j + 1))
        }
        return neighboors.toList()
    }
}

fun main () {
    val sol = Solution()

    val blob = arrayOf<IntArray>(
        intArrayOf(1,1),
        intArrayOf(1,1),
        intArrayOf(1,1)
    )

    val resp = sol.pacificAtlantic(blob)
    println("resp: ${ resp.joinToString("|") { it.joinToString("  ") } }")
}