/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        return if (root == p || root == q) {
            root
        } else if ((root!!.`val` < p!!.`val` && root?.`val` > q!!.`val`) || (root!!.`val` > p!!.`val` && root!!.`val` < q!!.`val`)) {
            root
        } else if (root!!.`val` < p!!.`val`) {
            lowestCommonAncestor(root!!.right, p, q)
        } else {
            lowestCommonAncestor(root!!.left, p, q)
        }
    }
}
