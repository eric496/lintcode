/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example
    Given 1->1->2, return 1->2.
    Given 1->1->2->3->3, return 1->2->3.
*/

/*
Thought process:
    Create a moving pointer, if the current node value equals the next node value, remove next node by cur.next = cur.next.next. 
    If not, move the pointer forward.
*/

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// O(n) time and O(1) space
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode runner = head;
        while (runner != null && runner.next != null) {
            if (runner.val == runner.next.val) {
                runner.next = runner.next.next;
            } else {
                runner = runner.next;
	    }
        }
        return head;
    }
} 
