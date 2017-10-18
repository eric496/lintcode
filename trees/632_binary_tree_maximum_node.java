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

// in-order traversal
public class Solution {
    public TreeNode maxNode(TreeNode root) {
        if (root == null) return null;
        TreeNode left = maxNode(root.left);
        TreeNode right = maxNode(root.right);
        if(left != null && left.val > root.val) root = left;
        if(right != null && right.val > root.val) root = right;
        return root;
    }
}
