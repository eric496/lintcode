/*
Find the nth to last element of a singly linked list. 
The minimum number of nodes in list is n.

Example
    Given a List  3->2->1->5->null and n = 2, return node  whose value is 1.
*/

/*
Thought process:
    Two pointers: 
        Let the first pointer traverse n steps first. Then let both pointers traverse at the same pace. 
        When the first pointer reaches the tail, the second pointer is right at the n-th to last node.
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
    public ListNode nthToLast(ListNode head, int n) {
        if (head == null || n < 1) return null;
        ListNode runner1 = head, runner2 = head;
        for (int i = 0; i < n; i++) { 
            runner1 = runner1.next;
        }
        while (runner1 != null) {
            runner1 = runner1.next;
            runner2 = runner2.next;
        }
        return runner2;
    }
}
