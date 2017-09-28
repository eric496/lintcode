/*
Convert a binary search tree to doubly linked list with in-order traversal.

Example
     Given a binary search tree:
        4
       / \
      2   5
     / \
    1   3
    return 1<->2<->3<->4<->5
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */

public class Solution {
    public DoublyListNode bstToDoublyList(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode node = root;
        s.push(node);
        DoublyListNode head = new DoublyListNode(0);
        DoublyListNode runner = head;
        while(!s.isEmpty()) {
            while(node != null && node.left != null) {
                s.push(node.left);
                node = node.left;
            }
            node = s.pop();
            DoublyListNode cur = new DoublyListNode(node.val);
            runner.next = cur;
            cur.prev = runner;
            runner = runner.next;
            node = node.right;
            if(node != null) s.push(node);
        }
        return head.next;
    }
}
