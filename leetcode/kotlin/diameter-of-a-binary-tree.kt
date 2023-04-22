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
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        val (_, max) = dfs(root)
        return max
    }

    private fun dfs(root: TreeNode?): Pair<Int, Int> { 
        if (root == null) {
            return Pair(0, 0)
        }
        val (leftMax, a) = dfs(root.left)
        val (rightMax, b) = dfs(root.right)
        val c = maxOf(rightMax + leftMax, a, b)
        return Pair(maxOf(rightMax, leftMax) + 1, c)
    }
}