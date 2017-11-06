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

/*
Thought process:
    Recursive solution:
        Base case: return null when current node is null.
        Recursive step: create the current root, clone the left subtree first, then the right subtree.     
*/

// recursive
public class Solution {
    public TreeNode cloneTree(TreeNode root) {
        if (root == null) return null;
        TreeNode cloneRoot = new TreeNode(root.val);
        cloneRoot.left = cloneTree(root.left);
        cloneRoot.right = cloneTree(root.right);
        return cloneRoot;
    }
}
