/*
Invert a binary tree.

Example
      1         1
     / \       / \
    2   3  => 3   2
       /       \
      4         4
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
    1. Recursive solution: swap nodes with an intermediate variable. 
       Then call the function recursively for left and right subtrees.
*/

public class Solution {
    public void invertBinaryTree(TreeNode root) {
        if(root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }
}

