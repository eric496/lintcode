/*
Given a linked list, determine if it has a cycle in it.

Example
    Given -21->10->4->5, tail connects to node index 1, return true

Challenge
    Follow up:
    Can you solve it without using extra space?
*/

/*
Thought process:
    Two pointers: a slow pointer travels 1 step each time and a fast pointer travels 2 steps each time. They will meet if there is a cycle.
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
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
