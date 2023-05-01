import kotlin.math.abs

class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        val sorted = nums.sorted()
        var closest = sorted[0] + sorted[1] + sorted[2]
        for (i in 0 until sorted.size - 2) {
            var j = i + 1
            var k = sorted.size - 1
            while (j < k) {
                val sum = sorted[i] + sorted[j] + sorted[k]
                if (abs(sum - target) < abs(closest - target)) {
                    closest = sum
                }
                if (sum == target) {
                    return target
                } else if (sum < target) {
                    j++
                } else {
                    k--
                }
            }
        }
        return closest
    }
}
