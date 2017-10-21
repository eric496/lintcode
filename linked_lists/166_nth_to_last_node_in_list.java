/*
Find the nth to last element of a singly linked list. 
The minimum number of nodes in list is n.

Example
    Given a List  3->2->1->5->null and n = 2, return node  whose value is 1.
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
    Two pointers: 
        The basic idea is let the first pointer run at the n-th node first.
        Then let both of them run with the same pace. When the first pointer runs at the tail, 
        the second pointer is right at the n-th to last node.
*/

public class Solution {
    ListNode nthToLast(ListNode head, int n) {
        if(head == null || n < 1) return null;
        ListNode runner = head;
        for(int i = 0; i < n; i++) 
            head = head.next;
        while(head != null) {
            head = head.next;
            runner = runner.next;
        }
        return runner;
    }
}
