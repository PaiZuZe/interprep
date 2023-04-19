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
    fun reverseList(head: ListNode?): ListNode? {
        var current: ListNode? = head
        var reverseHead: ListNode? = null
        while (current != null) {
            val temp = reverseHead
            reverseHead = ListNode(current!!.`val`)
            reverseHead.next = temp
            current = current?.next
        }
        return reverseHead
    }
}
