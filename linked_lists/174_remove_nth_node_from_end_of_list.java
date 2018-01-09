/*
Given a linked list, remove the nth node from the end of list and return its head.

Notice
    The minimum number of nodes in list is n.

Example
    Given linked list: 1->2->3->4->5->null, and n = 2.
    After removing the second node from the end, the linked list becomes 1->2->3->5->null.
*/

/*
Thought process:
    Similar to 166. N-th to Last Node in List. But be careful about two things:
    First, it is possible to remove the head node, so we need a dummy head to keep track of the first node.
    Second, different from 166, in order to remove the nth node from the end, we need to know (n+1)th node from the end.
    Compare to 166, we need to traverse (n-1) steps first, this is done by redirect the running pointer to the dummyhead which is actually one step ahead of the real head.
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
    ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) return null;
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
	head = sentinel;
        ListNode runner = head;
        for (int i = 0; i < n; i++) {
	    head = head.next;
	}
        while (head != null) {
            head = head.next;
            runner = runner.next;
        }
        runner.next = runner.next.next;
        return sentinel.next;
    }
}
