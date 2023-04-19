class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val sortedArray = Array<Pair<Int, Int>>(nums.size) { Pair(nums[it], it) }.sortedBy{ it.first }
        for (i in 0 until sortedArray.size - 1) {
            val j: Int = sortedArray.binarySearch(i + 1) { (sortedArray[i].first + it.first) - target }
            if (j >= 0) {
                return intArrayOf(sortedArray[i].second, sortedArray[j].second)
            }
        }
        return intArrayOf(-1, -1)
    }
}
