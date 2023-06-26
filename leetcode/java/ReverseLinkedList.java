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
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
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
