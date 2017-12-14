/*
Reverse a linked list from position m to n.

Notice
    Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.

Example
    Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.

Challenge
    Reverse it in-place and in one-pass
*/

/*
Thought process:

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

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode prev = dummyhead;
        for (int i = 0; i < m - 1; i++) {
	    prev = prev.next;
	}
        ListNode start = prev.next, next = start.next;
        // 1 -> 2 -> 3 -> 4 -> 5 ; m = 2; n = 4 --> prev = 1, start = 2, next = 3
        // dummyhead -> 1 -> 2 -> 3 -> 4 -> 5
        for (int i = 0; i < n - m; i++) {
            start.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = start.next;
        }
        return dummyhead.next;
    }
}
