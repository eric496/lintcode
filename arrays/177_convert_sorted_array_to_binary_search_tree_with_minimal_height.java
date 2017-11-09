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

/*
Thought process:
    In order to make the binary tree minimal height, we will make the tree as balanced as possible by splitting the array in half and build the tree recursively.
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

public class Solution {
    public TreeNode sortedArrayToBST(int[] A) {
        if (A == null || A.length == 0) return null;
        return buildTree(A, 0, A.length-1);
    }
    
    private TreeNode buildTree(int[] A, int low, int high) {
        if (low > high) return null; 
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(A[mid]);
        node.left = buildTree(A, low, mid-1);
        node.right = buildTree(A, mid+1, high);
        return node;
    }
}
