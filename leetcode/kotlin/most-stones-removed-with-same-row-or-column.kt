class Solution {
    fun removeStones(stones: Array<IntArray>): Int {
        val unionFind = IntArray(stones.size) { it }
        val height = IntArray(stones.size) { 0 }
        var resp = stones.size

        for (i in 0 until stones.size) {
            for (j in 0 until stones.size) {
                if (isNeighbor(i, j, stones)) {
                    val v = find(unionFind, i)
                    val w = find(unionFind, j)
                    if (v != w) {
                        union(unionFind, height, v, w)
                        resp--
                    }
                }
            }
        }
        return stones.size - resp
    }

    private fun isNeighbor(v: Int, w: Int, stones: Array<IntArray>): Boolean {
        val (vX, vY) = stones[v]
        val (wX, wY) = stones[w]
        if (vX == wX || vY == wY) {
            return true
        }
        return false
    }

    private fun union(unionFind: IntArray, height: IntArray, v: Int, w: Int) {
        if (height[v] > height[w]) {
            unionFind[w] = v
        } else {
            unionFind[v] = w
            if (height[v] == height[w]) {
                height[w] = height[w] + 1
            }
        }
    }

    private fun find(unionFind: IntArray, v: Int): Int {
        if (unionFind[v] != v) {
            unionFind[v] = find(unionFind, unionFind[v])
        }
        return unionFind[v]
    }
}

fun List<Pair<Int, Int>>.printable() = 
    this.joinToString("|") { "${it.first}, ${ it.second }" }


fun main () {
    val a1 = arrayOf<IntArray>(
        intArrayOf(0, 0),
        intArrayOf(0, 1),
        intArrayOf(1, 0),
        intArrayOf(1, 2),
        intArrayOf(2, 1),
        intArrayOf(2, 2)
    )

    val a2 = arrayOf<IntArray>(
        intArrayOf(0, 0),
        intArrayOf(0, 2),
        intArrayOf(1, 1),
        intArrayOf(2, 0),
        intArrayOf(2, 2)
    )

    val a3 = arrayOf<IntArray>(
        intArrayOf(0, 0)
    )


    val sol = Solution()
    
    val resp1 = sol.removeStones(a1)
    println("resp: $resp1, isExpected: ${ resp1 == 5 }")

    val resp2 = sol.removeStones(a2)
    println("resp: $resp2, isExpected: ${ resp2 == 3 }")

    val resp3 = sol.removeStones(a3)
    println("resp: $resp3, isExpected: ${ resp3 == 0 }")
}