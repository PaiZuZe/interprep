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
    fun rightSideView(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        rightSideView(root, list)
        return list.toList()   
    }

    private fun rightSideView(root: TreeNode?, list: MutableList<Int>) {
        if (root == null) {
            return
        }
        var queue = ArrayDeque<TreeNode>()
        queue.add(root!!)
        while(queue.isNotEmpty()) {
            val size = queue.size
            var node: TreeNode = queue.first()
            for (i in 0 until size) {
                node = queue.removeFirst()
                if (node.left != null) {
                    queue.add(node.left)
                }
                if (node.right != null) {
                    queue.add(node.right)
                }
            }
            list.add(node.`val`)
        }
    }
}