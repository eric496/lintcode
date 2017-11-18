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

/*
Thought process: 
    Almost same to 67. Binary Tree Inorder Traversal. Only difference is to connect nodes when it is popped from the stack.
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
        Stack<TreeNode> s = new Stack<>();
        DoublyListNode dummyhead = new DoublyListNode(-1);
        DoublyListNode runner = dummyhead;
        TreeNode node = root;
        while (!s.isEmpty() || node != null) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                node = s.pop();
                DoublyListNode cur = new DoublyListNode(node.val);
                runner.next = cur;
                cur.prev = runner;
                runner = runner.next;
                node = node.right;
            }
        }
        return dummyhead.next;
    }
}
