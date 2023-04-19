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
    fun oddEvenList(head: ListNode?): ListNode? {
        val start = ListNode(-1)
        val evenHead: ListNode? = head?.next
        var evenTail: ListNode? = start
        var node: ListNode? = head
        var prev: ListNode? = null
        
        while (node != null) {
            evenTail?.next = node.next
            node.next = node.next?.next
            prev = node
            
            evenTail = evenTail?.next
            node = node.next
        }
        prev?.next = evenHead
        return head
    }
}