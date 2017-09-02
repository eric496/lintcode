/*
Merge two sorted (ascending) linked lists and return it as a new sorted list. The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.

Example
Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummyhead = new ListNode(Integer.MIN_VALUE);
        ListNode head = dummyhead;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if(l1 != null) {
            head.next = l1;
        } else {
            head.next = l2;
        }
        return dummyhead.next;
    }
}

