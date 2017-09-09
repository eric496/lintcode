/*
Given a binary tree, return the postorder traversal of its nodes' values.

Example
    Given binary tree {1,#,2,3},
       1
        \
         2
        /
       3

    return [3,2,1].
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
    1. Recursive method: left - right - add
    2. Iterative method: use stack, basically an reverse opertion of preorder iterative solution.
*/

// recursive
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
    
    private void traverse(TreeNode root, ArrayList<Integer> result) {
        if(root == null) return;
        traverse(root.left, result);
        traverse(root.right, result);
        result.add(root.val);
    }
}

// iterative
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        while(!s.isEmpty() || root != null) {
            if(root != null) {
                s.push(root);
                result.add(root.val);
                root = root.right;
            } else {
                root = s.pop().left;
            }
        }
        Collections.reverse(result);
        return result;
    }
}
