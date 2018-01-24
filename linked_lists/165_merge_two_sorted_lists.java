/*
Merge two sorted (ascending) linked lists and return it as a new sorted list. The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.

Example
    Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.
*/

/*
Thought process:
    Do a pair comparison between nodes from two lists at each position. Append the smaller node to the new list. Keep three pointers moving forward accordingly.
    Notice that we need to return the first node of the new list, so we create a sentinel to track the head node of the new list.
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
        ListNode sentinel = new ListNode(-1);
        ListNode runner = sentinel, runner1 = l1, runner2 = l2;
        while (runner1 != null && runner2 != null) {
            if (runner1.val < runner2.val) {
                runner.next = new ListNode(runner1.val);
                runner1 = runner1.next;
            } else {
                runner.next = new ListNode(runner2.val);
                runner2 = runner2.next;
            }
            runner = runner.next;
        }
        while (runner1 != null) {
            runner.next = new ListNode(runner1.val);
            runner = runner.next;
            runner1 = runner1.next;
        }
        while (runner2 != null) {
            runner.next = new ListNode(runner2.val);
            runner = runner.next;
            runner2 = runner2.next;
        }
	// terminate the list properly
        runner.next = null;
        return sentinel.next;
    }
}

// a more concise version
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode sentinel = new ListNode(-1);
        ListNode runner = sentinel, runner1 = l1, runner2 = l2;
        while (runner1 != null || runner2 != null) {
            if (runner1 != null && runner2 != null) {
                if (runner1.val < runner2.val) {
                    runner.next = new ListNode(runner1.val); 
                    runner1 = runner1.next;
                } else {
                    runner.next = new ListNode(runner2.val);
                    runner2 = runner2.next;
                }
            } else if (runner1 != null) {
                runner.next = new ListNode(runner1.val);
                runner1 = runner1.next;
            } else if (runner2 != null) {
                runner.next = new ListNode(runner2.val);
                runner2 = runner2.next;
            }
            runner = runner.next;
        }
	// terminate the list
        runner.next = null;
        return sentinel.next;
    }
}

// early stopping - a tiny change but might save time
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode sentinel = new ListNode(-1);
        ListNode runner = sentinel, runner1 = l1, runner2 = l2;
        while (runner1 != null || runner2 != null) {
            if (runner1 != null && runner2 != null) {
                if (runner1.val < runner2.val) {
                    runner.next = new ListNode(runner1.val);
                    runner1 = runner1.next;
                } else {
                    runner.next = new ListNode(runner2.val);
                    runner2 = runner2.next;
                }
            } else if (runner1 != null) {
                runner.next = runner1;
                break;
            } else if (runner2 != null) {
                runner.next = runner2;
                break;
            }
            runner = runner.next;
        }
        return sentinel.next;
    }
}
