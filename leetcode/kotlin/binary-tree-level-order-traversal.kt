data class QueueCell (val node: TreeNode?, val level: Int)


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
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val levels = mutableListOf<MutableList<Int>>()
        val queue = ArrayDeque(listOf(QueueCell(root, 0)))
        while (queue.isNotEmpty()) {
            val cell: QueueCell = queue.removeFirst()
            val node: TreeNode? = cell.node
            val level: Int = cell.level

            if (node == null) {
                continue
            }
            if (levels.lastIndex == level) {
                levels[level].add(node?.`val`)
            } else {
                levels.add(mutableListOf<Int>(node?.`val`))
            }
            if (node?.left != null) {
                queue.add(QueueCell(node?.left, level + 1))
            }
            if (node?.right != null ) {
                queue.add(QueueCell(node?.right, level + 1))
            }
        }
        return List<List<Int>>(levels.size) { levels[it].toList() }
    }
}
