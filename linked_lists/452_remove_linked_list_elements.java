/*
Remove all elements from a linked list of integers that have value val.

Example
    Given 1->2->3->3->4->5->3, val = 3, you should return the list as 1->2->4->5
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
Thought process:
    1. Use two pointers.
*/

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyhead = new ListNode(Integer.MIN_VALUE);
        dummyhead.next = head;
        head = dummyhead;
        while(head.next != null) {
            if(head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummyhead.next;
    }
}
