/*
Check if two binary trees are identical. 
Identical means the two binary trees have the same structure and every identical position has the same value.

Example
        1             1
       / \           / \
      2   2   and   2   2
     /             /
    4             4
    are identical.
        1             1
       / \           / \
      2   3   and   2   3
     /               \
    4                 4
    are not identical.
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
thought process:
    1. Recursive solution: recursively check equality of the left and the right subtrees
       as well as their values.
*/

public class Solution {
    public boolean isIdentical(TreeNode a, TreeNode b) {
        if(a == null && b == null) return true;
        if(a != null && b != null) {
            return a.val == b.val && isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
        }
        return false;
    }
}
