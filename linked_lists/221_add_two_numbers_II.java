/*
You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in forward order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.

Example
    Given 6->1->7 + 2->9->5. That is, 617 + 295.
    Return 9->1->2. That is, 912.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */

/*
Thought process:
    1. Since it is a singly linked list, we cannot traverse to the end of the lists and add back, 
       because there is no pointers to the previous elements in the lists.
    2. Use 3 stacks instead: two stacks stores two lists' values. The other stack store the sum.
       Be careful of while condition as we need to consider the cases of different list length and 
       extra carry.
*/

public class Solution {
    public ListNode addLists2(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        Stack<Integer> s3 = new Stack<Integer>();
        int carry = 0;
        while(!s1.isEmpty() || !s2.isEmpty()) {
            if(!s1.isEmpty() && !s2.isEmpty()) {
                int sum = s1.pop() + s2.pop() + carry;
                s3.push(sum % 10);
                carry = sum / 10;
            } else if(!s1.isEmpty()) {
                int sum = s1.pop() + carry;
                s3.push(sum % 10);
                carry = sum / 10;
            } else if(!s2.isEmpty()) {
                int sum = s2.pop() + carry;
                s3.push(sum % 10);
                carry = sum / 10;
            }
        }
        if(carry != 0) s3.push(carry);
        ListNode head = new ListNode(0);
        ListNode runner = head;
        while(!s3.isEmpty()) {
            ListNode l = new ListNode(s3.pop());
            runner.next = l;
            runner = runner.next;
        }
        return head.next;
    }
}
