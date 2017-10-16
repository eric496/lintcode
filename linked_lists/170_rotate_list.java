/*
Given a list, rotate the list to the right by k places, where k is non-negative.

Example
    Given 1->2->3->4->5 and k = 2, return 4->5->1->2->3.
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
        if (head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        int i;
        for (i = 0; fast.next != null; i++)//Get the total length 
            fast = fast.next;
        for (int j = i - k % i; j > 0; j--) //Get the i-n%i th node
            slow=slow.next;
        fast.next = dummy.next; //Do the rotation
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}
