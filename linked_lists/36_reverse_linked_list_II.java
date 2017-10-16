/*
Reverse a linked list from position m to n.

Notice
    Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.

Example
    Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.

Challenge
    Reverse it in-place and in one-pass
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

// method 1
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for(int i = 0; i<m-1; i++) pre = pre.next;
        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed
        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5
        for(int i=0; i<n-m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
        return dummy.next;
    }
}

// method 2
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode start = new ListNode(0);
	    start.next = head;
	    ListNode tail = null;
	    ListNode beforeHead = start;
	    for (int i = 1; i <= n; i++) {
		if(i < m) {
		    beforeHead = head;
		    head = head.next;
	        } else if(i == m) {
		    tail = head;
		} else {
		    beforeHead.next = tail.next;
		    tail.next = tail.next.next;
		    beforeHead.next.next = head;
		    head = beforeHead.next;
		}
	    }
	return start.next;
    }
}
