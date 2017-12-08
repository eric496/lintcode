/*
Given a list, rotate the list to the right by k places, where k is non-negative.

Example
    Given 1->2->3->4->5 and k = 2, return 4->5->1->2->3.
*/

/*
Thought process:
    Three pointers: a dummy head, a fast runner, a slow runner. 
    The fast runner traverses the list and counts the length of the list. It points to the last element in the list. The slow runner traverses (len-k) elements.
    Finally rotate the list. Remember k = k%len in case k is larger than the length of the list.
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode fast = dummyhead, slow = dummyhead;
        int len;
        for (len = 0; fast.next != null; len++) { 
            fast = fast.next;
        }
        for (int j = 0; j < len - k % len; j++) {
       	    slow = slow.next;
        }
        fast.next = dummyhead.next;
        dummyhead.next = slow.next;
        slow.next = null;
        return dummyhead.next;
    }
}
