/*
Remove all elements from a linked list of integers that have value val.

Example
    Given 1->2->3->3->4->5->3, val = 3, you should return the list as 1->2->4->5
*/

/*
Thought process:
    The head pointer points to the first node in the list, which will lost track if it was removed.
    So we introduce a dummy head "runner" and let runner.next = head. 
    Runner iterates the whole list and remove eligible values, we return head.next which points to the real head node.
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode runner = new ListNode(Integer.MIN_VALUE);
        runner.next = head;
        head = runner;
        while(runner.next != null) {
            if(runner.next.val == val)
                runner.next = runner.next.next;
            else
                runner = runner.next;
        }
        return head.next;
    }
}
