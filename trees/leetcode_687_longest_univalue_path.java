/*
Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

Note: 
    The length of path between two nodes is represented by the number of edges between them.

Example 1:
    Input:

              5
             / \
            4   5
           / \   \
          1   1   5

    Output:
    2

Example 2:
    Input:

              1
             / \
            4   5
           / \   \
          4   4   5

    Output:
    2

Note: 
    The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000. 
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public int longestUnivaluePath(TreeNode root) {
        int[] result = new int[1];
        if (root != null) dfs(root, result);
        return result[0];
    }

    private int dfs(TreeNode node, int[] result) {
        int left = node.left != null ? dfs(node.left, result) : 0;
        int right = node.right != null ? dfs(node.right, result) : 0;
        int resl = node.left != null && node.left.val == node.val ? left + 1 : 0;
        int resr = node.right != null && node.right.val == node.val ? right + 1 : 0;
        result[0] = Math.max(result[0], resl + resr);
        return Math.max(resl, resr);
    }
}
