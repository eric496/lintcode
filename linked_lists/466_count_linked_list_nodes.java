/*
Count how many nodes in a linked list.

Example
    Given 1->3->5, return 3.
*/

/*
Thought process:
    Create a dummyhead and link its next pointer to the real head, then traverse the list and increment the counter at each iteration.
    We do not use the real head as the runner pointer because that will cause lost track of the list and it will be garbage collected.
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
    public int countNodes(ListNode head) {
        if (head == null) return 0;
        ListNode runner = new ListNode(-1);
        runner.next = head;
        int count = 0;
        while (runner.next != null) {
            count++;
            runner = runner.next;
        }
        return count;
    }
}
