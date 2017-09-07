/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example
    Given 1->1->2, return 1->2.
    Given 1->1->2->3->3, return 1->2->3.
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

/*
Thought process:
    1. Create a dummy head, if the value of the current node equals the value of the next node, 
       remove next node by point the current node to the node after next node.
*/
 
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
