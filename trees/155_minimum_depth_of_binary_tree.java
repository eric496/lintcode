/*
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Example
    Given a binary tree as follow:
      1
     / \ 
    2   3
       / \
      4   5
    The minimum depth is 2.
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
    1. Recursive solution: check if left node is empty. If so, recursively loop the right child. 
       Check if the right node is empty. If so, recursively loop the left child.
       If both children nodes are non empty, recursively loop left and right children and get the min.
*/

public class Solution {
    public static int minDepth(TreeNode root) {
        if (root == null)   return 0;
        if (root.left == null)  return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
