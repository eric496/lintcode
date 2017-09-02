/*
Given a sorted (increasing order) array, Convert it to create a binary tree with minimal height.

Notice
There may exist multiple valid solutions, return any of them.

Example
Given [1,2,3,4,5,6,7], return

     4
   /   \
  2     6
 / \    / \
1   3  5   7
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
1. Build a tree recursively
*/

public class Solution {
    public TreeNode sortedArrayToBST(int[] A) {  
        if(A == null || A.length == 0) return null;
        return buildTree(A, 0, A.length - 1);
    }  
    
    public TreeNode buildTree(int[] A, int start, int end) {
        if(start > end) return null;
        TreeNode node = new TreeNode(A[start + (end - start) / 2]);
        node.left = buildTree(A, start, start + (end - start) / 2 - 1);
        node.right = buildTree(A, start + (end - start) / 2 + 1, end);
        return node;
    }
} 
