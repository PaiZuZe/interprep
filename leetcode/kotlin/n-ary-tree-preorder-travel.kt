/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

class Solution {
    fun preorder(root: Node?): List<Int> {
        val list = mutableListOf<Int>()
        preorder(root, list)
        return list.toList()
    }

    fun preorder(root: Node?, list: MutableList<Int>) {
        if (root == null) {
            return
        } else {
            list.add(root.`val`)
            for (child in root.children) {
                preorder(child, list)
            }
        }
    }
}
