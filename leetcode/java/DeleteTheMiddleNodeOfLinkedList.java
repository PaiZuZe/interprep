/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class DeleteTheMiddleNodeOfLinkedList {
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPrev = null;
        boolean updateSlow = false;

        while (fast != null) {
            fast = fast.next;
            if (updateSlow) {
                slowPrev = slow;
                slow = slow.next;
            }
            updateSlow = !updateSlow;
        }
        if (slowPrev != null && slow != null) {
            slowPrev.next = slow.next;
        } else {
            head = null;
        }
        return head;
    }
}
