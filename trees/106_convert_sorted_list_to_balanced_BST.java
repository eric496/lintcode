/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

Example
                   2
    1->2->3  =>   / \
                 1   3
*/

/*
Thought process:
    Recursive solution:
        Base case: Return null if the current node is null. Return the current node if its next node is null.
        Recursive step: Use a slow and a fast pointers to find the mid node (root node for a subtree).
                        Break the sub linked list by tracking the node before the slow pointer (prev), and making prev.next = null.
                        Recursively build the left subtree (from head to slow) and the right subtree (from slow.next to end).
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
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 
 
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode prevSlow = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prevSlow = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prevSlow.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
