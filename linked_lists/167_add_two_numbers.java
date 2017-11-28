/*
You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.

Example
    Given 7->1->6 + 5->9->2. That is, 617 + 295.
    Return 2->1->9. That is 912.
    Given 3->1->5 and 5->9->2, return 8->0->8.
*/

/*
Thought process:
    It is the same trick applied to 408 and 655, except that here we need a linked list implementation.
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

public class Solution {
    public ListNode addLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode dummyhead = new ListNode(Integer.MIN_VALUE);
        ListNode runner = dummyhead;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            runner.next = new ListNode(sum%10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            runner = runner.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            runner.next = new ListNode(sum%10);
            carry = sum / 10;
            l1 = l1.next;
            runner = runner.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            runner.next = new ListNode(sum%10);
            carry = sum / 10;
            l2 = l2.next;
            runner = runner.next;
        }
        if (carry != 0) {
            runner.next = new ListNode(carry);
        }
        return dummyhead.next;
    }
}

// a concise version
public class Solution {
    public ListNode addLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        ListNode dummyhead = new ListNode(Integer.MIN_VALUE);
        ListNode runner = dummyhead;
        int sum = 0, carry = 0; 
        while (l1 != null || l2 != null) {
            sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            runner.next = new ListNode(sum%10);
            runner = runner.next;
            carry = sum / 10;
        }
        if (carry != 0) {
            runner.next = new ListNode(carry);
        }
        return dummyhead.next;
    }
}
