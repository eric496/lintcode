/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.

Example
    Given 1->4->3->2->5->2->null and x = 3,
    return 1->2->2->4->3->5->null.
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

/*
Thought process:
    1. Use two lists: one to store all nodes less than x; one to store all nodes greater than or equals to x.
       Merge the two lists at the end.
*/
 
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode lhead = new ListNode(Integer.MIN_VALUE);
        ListNode lrunner = lhead;
        ListNode rhead = new ListNode(Integer.MIN_VALUE);
        ListNode rrunner = rhead;
        while(head != null) {
            if(head.val < x) {
                lrunner.next = head;
                lrunner = lrunner.next;
            } else {
                rrunner.next = head;
                rrunner = rrunner.next;
            }
            head = head.next;
        }
        rrunner.next = null;
        lrunner.next = rhead.next;
        return lhead.next;
    }
}
