/*
Remove all elements from a linked list of integers that have value val.

Example
    Given 1->2->3->3->4->5->3, val = 3, you should return the list as 1->2->4->5
*/

/*
Thought process:
    The head node value might equal the target value, in which the head node will be removed. 
    In order to avoid this lost-track-of-head problem, we introduce a dummy head whose next node is the real head.
    Let the runner pointer points to the dummy head. Runner iterates the whole list and remove eligible values.
    Return dummyhead.next which points to the real head node after the removal operations.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// use a dummy head
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode runner = dummyhead;
        while (runner.next != null) {
            if (runner.next.val == val) {
                runner.next = runner.next.next;
            } else {
                // runner moves forward only if runner.next is not eligible
                runner = runner.next;
            }
        }
        return dummyhead.next;
    }
}

// even simpler
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode runner = new ListNode(Integer.MIN_VALUE);
        runner.next = head;
        head = runner;
        while (runner.next != null) {
            if (runner.next.val == val) {
                runner.next = runner.next.next;
            } else {
                runner = runner.next;
	    }
        }
        return head.next;
    }
}
