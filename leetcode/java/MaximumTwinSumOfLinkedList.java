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
public class MaximumTwinSumOfLinkedList {
    public int pairSum(ListNode head) {
        ListNode middle = getMiddle(head);
        ListNode reversedHead = reverseList(middle);
        int maximum = Integer.MIN_VALUE;

        ListNode nodeRight = head;
        ListNode nodeLeft = reversedHead;
        while (nodeRight != middle) {
            maximum = Math.max(maximum, nodeRight.val + nodeLeft.val);
            nodeRight = nodeRight.next;
            nodeLeft = nodeLeft.next;
        }
        return maximum;
    }

    private ListNode getMiddle(ListNode head) {
        ListNode middle = head;
        ListNode node = head;
        while (node != null && node.next != null) {
            node = node.next.next;
            middle = middle.next;
        }
        return middle;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        ListNode node = head;

        while (node != null) {
            ListNode nextNode = node.next;
            node.next = prevNode;
            prevNode = node;
            node = nextNode;
        }
        return prevNode;
    }
}
