/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Notice
    You may assume that duplicates do not exist in the tree.

Example
    Given inorder [1,2,3] and postorder [1,3,2], return a tree:
      2
     / \
    1   3
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder, inorder, postorder.length-1, inorder.length-1, 0);
    }

    private TreeNode helper(int[] postorder, int[] inorder, int postStart, int inStart, int inEnd) {
        if (postStart < 0 || inStart < inEnd) return null;
        //The last element in postorder is the root.
        TreeNode root = new TreeNode(postorder[postStart]);
        //find the index of the root from inorder. Iterating from the end.
        int inIndex = inStart;
        for (int i = inStart; i >= inEnd; i--) {
            if (inorder[i] == postorder[postStart]) inIndex = i;
        }
        //build right and left subtrees. Again, scanning from the end to find the sections.
        root.right = helper(postorder, inorder, postStart-1, inStart, inIndex + 1);
        root.left = helper(postorder, inorder, postStart - (inStart - inIndex) -1, inIndex - 1, inEnd);
        return root;
    }
}
