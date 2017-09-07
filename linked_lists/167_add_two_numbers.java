/*
You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.

Example
Given 7->1->6 + 5->9->2. That is, 617 + 295.
Return 2->1->9. That is 912.
Given 3->1->5 and 5->9->2, return 8->0->8.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */

/*
Thought process:
    1. It is the same trick applied to 408 and 655, except that here we need a linked list implementation.
       Use two pointers to solve this problem.
*/

public class Solution {
	public ListNode addLists(ListNode A, ListNode B) {
		if(A == null && B == null) return null;
		ListNode head = new ListNode(Integer.MIN_VALUE);
		ListNode runner = head;
		int carry = 0;
		while(A != null && B != null) {
			int sum = A.val + B.val + carry;
			runner.next = new ListNode(sum % 10);
			carry = sum / 10;
			A = A.next;
			B = B.next;
			runner = runner.next;
		}
		while(A != null) {
			int sum = A.val + carry;
			runner.next = new ListNode(sum % 10);
			carry = sum / 10;
			A = A.next;
			runner = runner.next;		
		}
		while(B != null) {
			int sum = B.val + carry;
			runner.next = new ListNode(sum % 10);
			carry = sum / 10;
			B = B.next;
			runner = runner.next;
		}
		if(carry != 0) runner.next = new ListNode(carry);
		return head.next;
	}
}
