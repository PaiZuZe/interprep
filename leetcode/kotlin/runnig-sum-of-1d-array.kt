class Solution {
    fun runningSum(nums: IntArray): IntArray {
        val resp = IntArray(nums.size) { 0 }
        resp[0] = nums[0]
        for (i in 1 until nums.size) {
            resp[i] = resp[i - 1] + nums[i]
        }
        return resp
    }
}
