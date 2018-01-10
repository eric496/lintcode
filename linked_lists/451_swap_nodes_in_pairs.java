/*
Given a linked list, swap every two adjacent nodes and return its head.

Example
    Given 1->2->3->4, you should return the list as 2->1->4->3.
*/

/*
Thought process:
    Two pointers. Be careful about the process of swapping especially the order. Better draw a graph to understand how it works.
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
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode runner = sentinel;
        ListNode next = null;
        ListNode nextNext = null;
        while (runner.next != null && runner.next.next != null) {
            next = runner.next;
            nextNext = runner.next.next;
            next.next = nextNext.next;
            nextNext.next = next;
            runner.next = nextNext;
            runner = next;
        }
        return sentinel.next;
    }
}
