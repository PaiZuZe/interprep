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
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var head: ListNode? = null
        var current: ListNode? = head
        var list1Node = list1
        var list2Node = list2
        while (list1Node != null && list2Node != null) {
            if (list1Node.`val` < list2Node.`val`) {
                if (head == null) {
                    head = ListNode(list1Node.`val`)
                    current = head
                } else {
                    current?.next = ListNode(list1Node.`val`)
                    current = current?.next
                }
                list1Node = list1Node.next
            } else {
                if (head == null) {
                    head = ListNode(list2Node.`val`)
                    current = head
                } else {
                    current?.next = ListNode(list2Node.`val`)
                    current = current?.next
                }
                list2Node = list2Node.next
            }
        }

        while (list1Node != null) {
            if (head == null) {
                head = ListNode(list1Node.`val`)
                current = head
            } else {
                current?.next = ListNode(list1Node.`val`)
                current = current?.next
            }
            list1Node = list1Node.next
        }


        while (list2Node != null) {
            if (head == null) {
                head = ListNode(list2Node.`val`)
                current = head
            } else {
                current?.next = ListNode(list2Node.`val`)
                current = current?.next  
            }
            list2Node = list2Node.next
        }


        return head
    }
}
