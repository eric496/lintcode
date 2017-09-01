/*
Given a linked list, swap every two adjacent nodes and return its head.

Example
Given 1->2->3->4, you should return the list as 2->1->4->3.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next != null && head.next.next != null) {
            ListNode next = head.next;
            ListNode nextNext = head.next.next;
            head.next = nextNext; 
            next.next = nextNext.next;
            nextNext.next = next;
            head = next;
        }
        return dummy.next;
    }
}
