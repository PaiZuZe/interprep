/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun detectCycle(head: ListNode?): ListNode? {
        val links = hashMapOf<ListNode, Int>()
        var i = 0
        var currNode: ListNode? = head
        while (currNode != null) {
            if (links[currNode!!] == null) {
                links[currNode!!] = i
                currNode = currNode!!.next
                i++
            } else {
                return currNode
            }
        }
        return null
    }
}
