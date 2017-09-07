/*
Given a linked list, remove the nth node from the end of list and return its head.

Notice
    The minimum number of nodes in list is n.

Example
    Given linked list: 1->2->3->4->5->null, and n = 2.
    After removing the second node from the end, the linked list becomes 1->2->3->5->null.
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

/*
Thought process:
    1. Same to 166, except that we need one more step to remove the specified node. 
*/
 
public class Solution {
    ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0) return null;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode runner = dummy;
        for(int i = 0; i < n; i++) head = head.next;
        while(head != null) {
            head = head.next;
            runner = runner.next;
        }
        runner.next = runner.next.next;
        return dummy.next;
    }
}
