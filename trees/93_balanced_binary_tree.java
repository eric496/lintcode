/*
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example
    Given binary tree A = {3,9,20,#,#,15,7}, B = {3,#,20,15,7}

    A)  3            B)    3 
       / \                  \
      9  20                 20
        /  \                / \
       15   7              15  7
    The binary tree A is a height-balanced binary tree, but B is not.
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
 */

/*
Thought process:
    1. Recursive solution: (similar to 93. Maximum depth of binary tree)
           Base case: return true when the current node is null.
           Recursive steps: calculate the maximum depth of the left and right subtrees,
                            check balance of the left subtree, and that of the right subtree.
*/

// recursive 
public class Solution {
        public boolean isBalanced(TreeNode root) {
                if(root == null) return true;
                return Math.abs(maxDepth(root.right) - maxDepth(root.left)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        public int maxDepth(TreeNode node) {
                if(node == null) return 0;
                return Math.max(maxDepth(node.right), maxDepth(node.left)) + 1;
        }
}
