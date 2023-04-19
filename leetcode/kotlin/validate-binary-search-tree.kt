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
    fun isValidBST(root: TreeNode?): Boolean {
        val elements: IntArray = treeInOrder(root)
        return orderd(elements)
    }

    fun treeInOrder(root: TreeNode?): IntArray {
        val list = mutableListOf<Int>()
        treeInOrder(root, list)
        return list.toIntArray()
    }

    private fun treeInOrder(root: TreeNode?, list: MutableList<Int>) {
        if (root != null) {
            treeInOrder(root!!.left, list)
            list.add(root.`val`)
            treeInOrder(root!!.right, list)
        }
    }

    private fun orderd(array: IntArray): Boolean {
        if (array.size <= 1) {
            return true
        }
        for (i in 1 until array.size) {
            if (array[i - 1] >= array[i]) {
                return false
            }
        }
        return true
    }
}
