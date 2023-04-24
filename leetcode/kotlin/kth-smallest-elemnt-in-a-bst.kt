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
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        return dfs(root, k)[k - 1]
    }

    private fun dfs(root: TreeNode?, k: Int): List<Int> {
        if (root == null) {
            return listOf<Int>()
        }
        return dfs(root.left, k) + listOf(root.`val`) + dfs(root.right, k)
    }
}