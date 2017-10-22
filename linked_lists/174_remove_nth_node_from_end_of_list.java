/*
Given a linked list, remove the nth node from the end of list and return its head.

Notice
    The minimum number of nodes in list is n.

Example
    Given linked list: 1->2->3->4->5->null, and n = 2.
    After removing the second node from the end, the linked list becomes 1->2->3->5->null.
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
    Similar to 166. N-th to Last Node in List. But here, we should be careful about two things:
    	First, it is possible to remove the head node, so we need a dummy head to keep track of the first node.
        Second, different from 166, in order to remove the nth node from the end, we need to know (n+1)th node from the end.
        Set n_plus_one_from_the_end.next = n_plus_one_from_the_end.next.next
        Set the second running pointer (runner in this solution) to point to the dummy head, which means it is one step behind the first running pointer (head in this solution).
        So when the first running pointer reaches the tail, the second pointer points right to the node before n-th node from the end, which allows the operation of removal. 
*/
 
public class Solution {
    ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n < 1) return null;
        ListNode dummyhead = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode runner = dummy;
        for(int i = 0; i < n; i++) head = head.next;
        while(head != null) {
            head = head.next;
            runner = runner.next;
        }
        runner.next = runner.next.next;
        return dummy.next;
    }
}
