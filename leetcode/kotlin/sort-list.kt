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
    fun sortList(head: ListNode?): ListNode? {
        if (head == null || head.next == null) {
            return head
        }
        val middle = getMiddle(head)
        val nextMiddle = middle?.next
        middle?.next = null
        val l1 = sortList(head)
        val l2 = sortList(nextMiddle)
        return merge(l1, l2)
    }

    private fun getMiddle(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        val start = ListNode(-10000000)
        var fastNode: ListNode? = start
        var slowNode: ListNode? = start
        start.next = head
        var slow = false
        while (fastNode != null) {
            if (slow) {
                slowNode = slowNode?.next
            }
            fastNode = fastNode.next
            slow = !slow
            
        }
        return slowNode
    }

    private fun merge(head1: ListNode?, head2: ListNode?): ListNode? {
        var node1: ListNode? = head1
        var node2: ListNode? = head2
        var tail: ListNode? = ListNode(-1)

        while (node1 != null && node2 != null) {
            if (node1.`val` < node2.`val`) {
                tail?.next = node1
                tail = node1
                node1 = node1.next
            } else {
                tail?.next = node2
                tail = node2
                node2 = node2.next       
            }
        }

        while (node1 != null) {
            tail?.next = node1
            tail = node1
            node1 = node1.next
        }

        while (node2 != null) {
            tail?.next = node2
            tail = node2
            node2 = node2.next
        }

        return if (head1 == null) {
            head2
        } else if (head2 == null) {
            head1
        } else if (head1.`val` < head2.`val`) {
            head1
        } else {
            head2
        }
    }
}