/*
Given a linked list, determine if it has a cycle in it.

Example
    Given -21->10->4->5, tail connects to node index 1, return true

Challenge
    Follow up:
    Can you solve it without using extra space?
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

// two pointers 
public class Solution {
    public boolean hasCycle(ListNode head) {  
        if(head == null || head.next == null) return false;
        ListNode walker = head;
        ListNode runner = head.next;
        while(runner.next != null && runner.next.next != null) {
            if(walker == runner) return true;
            walker = walker.next;
            runner = runner.next.next;
        }
        return false;
    }
}
