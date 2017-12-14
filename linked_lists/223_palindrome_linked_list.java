/*
Implement a function to check if a linked list is a palindrome.

Example
    Given 1->2->1, return true

Challenge
    Could you do it in O(n) time and O(1) space?
*/

/*
Thought process:
    Use two pointers traversing the list with one step and two steps at a time respectively.
    Reverse the first half and compare it with the second half, return false if any different node value found. 
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
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
	}
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
