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
    Create two lists, one storing every node whose value is less than x, 
    the other storing those whose value is greater than or equals to x.
    Two dummy heads and two running pointers will be needed because:
        1) The head of the first list will be returned as the result.
        2) The head of the second list will be appended to the tail of the first list.
        3) Two running pointers will iterate the whole list to select candidate node.
    Don't forget to set the second list's tail to null for proper ending of a linked list.
*/

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode head1 = new ListNode(Integer.MIN_VALUE);
        ListNode head2 = new ListNode(Integer.MIN_VALUE);
        ListNode runner1 = head1;
        ListNode runner2 = head2;
        while(head != null) {
            if(head.val < x) {
                runner1.next = head;
                runner1 = runner1.next;
            } else {
                runner2.next = head;
                runner2 = runner2.next;
            }
            head = head.next;
        }
        runner2.next = null;
        runner1.next = head2.next;
        return head1.next;
    }
} 
