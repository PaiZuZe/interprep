class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        if (sum % 2 == 1) {
            return false
        }

        val dp = Array(nums.size + 1) { BooleanArray((sum / 2) + 1) { false } }
        dp[0][0] = true
        for (i in 1..nums.size) {
            for (j in 0..(sum/2)) {
                dp[i][j] = if (j - nums[i - 1] >= 0) {
                    dp[i - 1][j] || dp[i - 1][j - nums[i - 1]]
                } else {
                    dp[i - 1][j]
                }
            }
        }
        return dp[nums.size][sum / 2]
    }
}