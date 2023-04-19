class Solution {
    fun pivotIndex(nums: IntArray): Int {
        var rightSum = nums.sum() - nums[0]
        var leftSum = 0
        for (i in nums.indices) {
            if (rightSum == leftSum ) {
                return i
            }
            if (i == nums.lastIndex) {
                rightSum = 0
            } else {
                rightSum -= nums[i + 1]
            }
            leftSum += nums[i]
        }
        return -1
    }
}
