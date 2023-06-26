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
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head != null) {
            ListNode oddPointer = head;
            ListNode evenPointer = head.next;
            ListNode evenHead = head.next;

            while (oddPointer.next != null && oddPointer.next.next != null) {
                ListNode temp = evenPointer.next.next;
                oddPointer.next = oddPointer.next.next;
                evenPointer.next = temp;
                oddPointer = oddPointer.next;
                evenPointer = evenPointer.next;
            }
            oddPointer.next = evenHead;
        }
        return head;
    }
}
