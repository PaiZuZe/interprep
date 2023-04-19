class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val pq = PriorityQueue<Int>(stones.size) { x: Int, y: Int -> y - x}
        stones.forEach {pq.add(it)}
        while (pq.size > 1) {
            val y = pq.poll()
            val x = pq.poll()
            if (x != y) {
                pq.add(y - x)
            }
        }
        return pq.poll() ?: 0
    }
}
