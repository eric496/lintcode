/*
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
    In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root, right = root;
        int leftHeight = 0, rightHeight = 0;
        while(left != null) {
            left = left.left;
            leftHeight++;
        } 
        while(right != null) {
            right = right.right;
            rightHeight++;
        }
        if(leftHeight == rightHeight) return (1 << leftHeight) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
