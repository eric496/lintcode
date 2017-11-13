/*
Merge two sorted (ascending) linked lists and return it as a new sorted list. The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.

Example
    Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.
*/

/*
Thought process:
    Do a pair comparison between nodes from two lists at each position. Append the smaller node to the new list. Keep three pointers moving forward accordingly.
    Notice that we need to return the first node of the new list, so we create a dummy head to track the head node of the new list.
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
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummyhead = new ListNode(Integer.MIN_VALUE);
        ListNode runner = dummyhead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                runner.next = l1;
                l1 = l1.next;
            } else {
                runner.next = l2;
                l2 = l2.next;
            }
            runner = runner.next;
        }
        if (l1 != null) {
	    runner.next = l1;
	}
        if (l2 != null) {
	    runner.next = l2;
	}
        return dummyhead.next;
    }
}
