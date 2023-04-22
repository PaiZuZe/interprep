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
    var sol = 0

    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        if (root == null) {
            return 0
        }

        return dfs(root, targetSum.toLong()) + 
            pathSum(root.left, targetSum) + 
            pathSum(root.right, targetSum)
    }

    private fun dfs(root: TreeNode?, targetSum: Long):  Int {
        if (root == null) {
            return 0
        }
        val countLeft = dfs(root.left, targetSum - root.`val`.toLong())
        val countRight = dfs(root.right, targetSum - root.`val`.toLong())

        val newCount = countLeft + countRight +
            if (targetSum - root.`val` == 0L) 1 else 0

        return newCount
    }
}