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
    1. O(n) solution using 3 stacks:
           Since it is a singly linked list, traverse the list backward is not possible, because there is no pointer to the previous element for a node.
           Instead we can use 3 stacks, two storing the node values from the two lists, one storing the sum in reverse order. 
           Pop the top element from the stack iteratively and append it to the result list.    
    2. O(n) solution using 2 stacks:
           The sum stack can be saved by repeatedly swap the head pointer with a new head pointer.
*/

// O(n) time using 3 stacks
public class Solution {
    public ListNode addLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        Stack<Integer> s3 = new Stack<>();
        int carry = 0, sum = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            sum = s1.pop() + s2.pop() + carry;
            s3.push(sum % 10);
            carry = sum / 10;
        }
        while (!s1.isEmpty()) {
            sum = s1.pop() + carry;
            s3.push(sum%10);
            carry = sum / 10;
        }
        while (!s2.isEmpty()) {
            sum = s2.pop() + carry;
            s3.push(sum%10);
            carry = sum / 10;
        }
        if (carry != 0) {
            s3.push(carry);
        }
        ListNode dummyhead = new ListNode(-1);
        ListNode runner = dummyhead;
        while (!s3.isEmpty()) {
            ListNode node = new ListNode(s3.pop());
            runner.next = node;
            runner = runner.next;
        }
        return dummyhead.next;
    }
}

// O(n) time using 2 stacks
public class Solution {
    public ListNode addLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        ListNode list = new ListNode(Integer.MIN_VALUE);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) {
		sum += s1.pop();
	    }
            if (!s2.empty()) {
		sum += s2.pop();
	    }
            list.val = sum % 10;
            ListNode head = new ListNode(sum/10);
            head.next = list;
            list = head;
            sum /= 10;
        }
        return list.val == 0 ? list.next : list;
    }
}
