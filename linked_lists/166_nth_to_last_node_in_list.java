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
    1. Two pointers: let first run till it reaches nth element. 
       Then let both run, when the first reaches the end of the array, 
       the second is the nth to the last element.
*/

public class Solution {
    ListNode nthToLast(ListNode head, int n) {
        if(head == null) return null;
        ListNode runner = head;
        for(int i = 0; i < n; i++) head = head.next;
        while(head != null) {
            head = head.next;
            runner = runner.next;
        }
        return runner;
    }
}
