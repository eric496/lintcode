/*
Reverse a linked list.

Example
For linked list 1->2->3, the reversed linked list is 3->2->1
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
 
public class Solution {
    public ListNode reverse(ListNode head) {
        if(head == null) return null;
        ListNode prev = null;
        while(head != null) {
             ListNode next = head.next;
             head.next = prev;
             prev = head;
             head = next;
        }
        return prev;
    }
}
