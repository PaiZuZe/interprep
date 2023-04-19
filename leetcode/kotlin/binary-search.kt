class Solution {
    fun search(nums: IntArray, target: Int): Int {
        return binarySearch(nums, target, 0, nums.size)
    }

    fun binarySearch(nums: IntArray, target: Int, lo: Int, hi: Int): Int {
        if (hi <= lo) {
            return -1
        }
        val middle = ((hi - lo) / 2) + lo
        return if (nums[middle] == target) {
            middle
        } else if (nums[middle] < target) {
            binarySearch(nums, target, middle + 1, hi)
        } else {
            binarySearch(nums, target, lo, middle)
        }
    }
}
