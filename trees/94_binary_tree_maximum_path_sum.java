/*
Given a binary tree, find the maximum path sum.
The path may start and end at any node in the tree.

Example
    Given the below binary tree:
      1
     / \
    2   3
    return 6.
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
    Each path has a highest node, which is also the lowest common ancestor of all other nodes in the path. 
    A recursive function needs to calculate the max path sum with the input node as the highest node. i.e.
                                       root
                                      /    \
                                 max left  max right
    Return max path sum that can be extended to current node's parent

    Recursive solution:
        Base case: return 0 when current node is null.
        Recursive steps: calculate the max path sum of the left and the right subtrees.
                         return the larger path sum between the left and the right subtrees, plus its parent value
        Update max during recursion. 
*/

public class Solution {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }

    public int maxPath(TreeNode root) {
        if (root == null) return 0;
        int left = maxPath(root.left);
        int right = maxPath(root.right);
        // update max
        max = Math.max(max, left + right + root.val);
        max = Math.max(max, root.val);
        return Math.max(left, right) + root.val;
    }
}
