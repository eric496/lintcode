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

/*
Thought process:
    1. Recursive solution: 
           The last node in the postorder array is the root, look for the same value in the inorder array, 
           the left part is the left subtree, and the right part is the right subtree.
           
*/

// recursive

// iterative  
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        int inIndex = inorder.length - 1;
        int postIndex = postorder.length - 1;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode root = new TreeNode(postorder[postIndex]);
        s.push(root);
        postIndex--;
        while (postIndex >= 0) {
            while (!s.isEmpty() && s.peek().val == inorder[inIndex]) {
                prev = s.pop();
                inIndex--;
            }
            TreeNode node = new TreeNode(postorder[postIndex]);
            if (prev != null) {
                prev.left = node;
            } else if (!s.isEmpty()) {
                TreeNode topNode = s.peek();
                topNode.right = node;
            }
            s.push(node);
            prev = null;
            postIndex--;
        }
        return root;
    }
}

