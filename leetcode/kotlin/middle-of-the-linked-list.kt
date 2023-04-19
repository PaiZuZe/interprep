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
    fun middleNode(head: ListNode?): ListNode? {
        var middle: ListNode? = head
        var tail: ListNode? = head
        var i = 0
        while (tail != null) {
            tail = tail?.next
            if (i % 2 == 1) {
                middle = middle?.next
            }
            i++
        }
        return middle
    }
}
