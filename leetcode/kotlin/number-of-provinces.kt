class Solution {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val n = isConnected.size
        val unionFind = IntArray(n) { it }
        val height = IntArray(n) { 0 }
        var resp = n
        
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (isConnected[i][j] == 1) {
                    val v = find(unionFind, i)
                    val w = find(unionFind, j)
                    if (v != w) {
                        union(unionFind, height, v, w)
                        resp--
                    }
                }
            }
        }
        return resp
    }

    private fun union(unionFind: IntArray, height: IntArray, v: Int, w: Int) {
        if (height[v] > height[w]) {
            unionFind[w] = v
        } else {
            unionFind[v] = w
            if (height[v] == height[w]) {
                height[w] += 1
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
