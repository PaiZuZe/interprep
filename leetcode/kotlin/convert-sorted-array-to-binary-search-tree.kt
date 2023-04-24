/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return sortedArrayToBST(nums, 0 , nums.size)
    }

    private fun sortedArrayToBST(nums: IntArray, start: Int, end: Int): TreeNode? {
        if (end <= start) {
            return null
        }
        val middle: Int = ((end - start) / 2) + start
        val root = TreeNode(nums[middle])
        val left = sortedArrayToBST(nums, start, middle)
        val right = sortedArrayToBST(nums, middle + 1, end)
        root.left = left
        root.right = right
        return root
    }
}