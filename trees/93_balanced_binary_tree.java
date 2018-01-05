/*
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example
    Given binary tree A = {3,9,20,#,#,15,7}, B = {3,#,20,15,7}

    A)  3            B)    3 
       / \                  \
      9  20                 20
        /  \                / \
       15   7              15  7
    The binary tree A is a height-balanced binary tree, but B is not.
*/

/*
Thought process:
    Recursive solution: (similar to 93. Maximum Depth of Binary Tree)
        1. Top-down approach:
               Base case: return true when the current node is null.
               Recursive steps: calculate the maximum depth of the left and right subtrees, check balance of the left subtree, and that of the right subtree.
        2. Bottom-up approach: 
               Base case: return true when the current node is null.
               Recursive steps: return -1 once it is not balanced. Otherwise return the depth of the current tree.
   
    Some tips about how to think recursively:
        First, think of the base case - under what circumstances should it break the recursion?
               think of the recursive step - what is the new input?
        Second, think from the macro perspective - how to decompose the problem by its defition instead of the micro perspective - how to design each step in the recursion.
                
        Take this problem as an example. First, the base case is when the current node is null, which means we have recursively traversed the subtree and there is no "bad case",
        so we will return true. The recursive step is about how can we solve the sub problem with the same structure. The new input is just root.left and root.right since they are 
        subtrees with the same structure. 
        Second, by defition, a balanced binary tree is a tree in which the depth of the two subtrees differ by at most 1 and subtrees are balanced trees as well.
        This needs a helper function to count the depth of the subtrees, which is as well a recursive function. The max depth is the depth of the left or right subtrees whichever is greater. 
        Remember to add 1 because we need to add the root level as well.  
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

// O(n^2) time : top-down approach
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(maxDepth(root.right) - maxDepth(root.left)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(maxDepth(node.right), maxDepth(node.left)) + 1;
    }
}

// O(n) time: bottom-up approach
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        if (leftDepth == -1) return -1;
        int rightDepth = maxDepth(root.right);
        if (rightDepth == -1) return -1;
        if (Math.abs(leftDepth - rightDepth) > 1)  return -1;
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
