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
import kotlin.math.abs

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        if (!isBalanced(root?.left) || !isBalanced(root?.right)) {
            return false
        } else {
            val leftHeight = getHigth(root?.left)
            val rightHeight = getHigth(root?.right)
            if (abs(leftHeight - rightHeight) > 1) {
                return false
            } else {
                return true
            }
        }
    }
    
    private fun getHigth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return maxOf(getHigth(root?.left), getHigth(root?.right)) + 1
    }
}