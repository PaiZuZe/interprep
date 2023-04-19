import kotlin.math.min

class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val n: Int = cost.size
        val totalCosts = IntArray(n) { 0 }
        for (i in 2 until n) {
            totalCosts[i] = min(totalCosts[i - 1] + cost[i - 1], totalCosts[i - 2] + cost[i - 2])
        }
        return min(totalCosts[n - 1] + cost[n - 1], totalCosts[n - 2] + cost[n - 2])
    }
}
