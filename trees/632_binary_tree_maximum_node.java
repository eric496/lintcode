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

/*
Thought process:
    In order to find the maximum node, we need to traverse the binary tree.
    Tree traversal can be done recursively in a bottom-up order. 
    Base case: return null if current node is null.
    Recursive steps: Traverse left subtree and then the right. 
                     If left child value is greater than root value, then set left child as root. 
                     Similarly, if right child value is greater than root value, then set right child as root.
                     Root node is always the current maximum node. 
*/

public class Solution {
    public TreeNode maxNode(TreeNode root) {
        if(root == null) return null;
        TreeNode left = maxNode(root.left);
        TreeNode right = maxNode(root.right);
        if(left != null && left.val > root.val) root = left;
        if(right != null && right.val > root.val) root = right;
        return root;
    }
}
