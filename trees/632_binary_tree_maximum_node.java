/*
Find the maximum node in a binary tree, return the node.

Example
    Given a binary tree:
         1
       /   \
     -5     2
     / \   /  \
    0   3 -4  -5 
    return the node with value 3.
*/

public class Solution {
    public TreeNode maxNode(TreeNode root) {
        if(root == null) return null;
        TreeNode left = maxNode(root.left);
        TreeNode right = maxNode(root.right);
        return max(root, max(left, right));
    }
    
    TreeNode max(TreeNode left, TreeNode right) {
        if(left == null) return right;
        if(right == null) return left;
        return left.val < right.val ? right : left;
    }
}
