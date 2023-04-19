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
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var fastNode = head
        var slowNode: ListNode? = null
        for (i in 0 until n) {
            fastNode = fastNode?.next
        }
        while (fastNode != null) {
            fastNode = fastNode?.next
            if (slowNode == null) {
                slowNode = head
            } else {
                slowNode = slowNode?.next
            }
        }
        slowNode?.next = slowNode?.next?.next
        return if (slowNode == null) {
            head?.next
        } else {
            head
        }
    }
}
