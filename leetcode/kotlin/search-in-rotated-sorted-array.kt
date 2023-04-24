class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val pivot = findPivot(nums, 0, nums.size, nums.last())
        return binSearchWithPivot(nums, target, 0, nums.size, pivot)
    }

    private fun binSearchWithPivot(nums: IntArray, target: Int, start: Int, end: Int, pivot: Int): Int {
        if (end <= start) {
            return -1
        }
        val middle = (((end - start) / 2) + start)
        if (nums[(middle + pivot) % nums.size] == target) {
            return (middle + pivot) % nums.size
        } else if (nums[(middle + pivot) % nums.size] < target) {
            return binSearchWithPivot(nums, target, middle + 1, end, pivot)
        } else {
            return binSearchWithPivot(nums, target, start, middle, pivot)
        }
    }

    private fun findPivot(nums: IntArray, start: Int, end: Int, comp: Int): Int {   
        if (start == end) {
            return start
        }

        val middle = ((end - start) / 2) + start
        return if (nums[middle] <= comp) {
            findPivot(nums, start, middle, nums[middle])
        } else {
            findPivot(nums, middle + 1, end, comp)
        }
    }
}
