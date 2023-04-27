import kotlin.math.max

class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) {
            return nums[0]
        }
        val cache = IntArray(nums.size) { 0 }
        cache[cache.size - 1] = nums[nums.size - 1]
        cache[cache.size - 2] = max(nums[nums.size - 2], cache[cache.size - 1])

        for (i in nums.size - 3 downTo 0) {
            cache[i] = max(nums[i] + cache[i + 2], cache[i + 1])
        }
        return cache[0]
    }
}