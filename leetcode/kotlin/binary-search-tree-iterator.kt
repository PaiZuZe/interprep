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
class BSTIterator(root: TreeNode?) {
    private val queue = ArrayDeque<Int>()

    init {
        inOrder(root)
    }

    fun next(): Int = queue.removeFirst()

    fun hasNext(): Boolean = queue.isNotEmpty()

    private fun inOrder(root: TreeNode?) {
        if (root == null) {
            return
        }
        inOrder(root.left)
        queue.add(root.`val`)
        inOrder(root.right)
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */