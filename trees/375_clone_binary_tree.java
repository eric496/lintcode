/*
For the given binary tree, return a deep copy of it.

Example
Given a binary tree:

     1
   /  \
  2    3
 / \
4   5

return the new binary tree with same structure and same value:

     1
   /  \
  2    3
 / \
4   5
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
    public TreeNode cloneTree(TreeNode root) {
        if(root == null) return null;
        TreeNode clone_root = new TreeNode(root.val);
        clone_root.left = cloneTree(root.left);
        clone_root.right = cloneTree(root.right);
        return clone_root;
    }
}
