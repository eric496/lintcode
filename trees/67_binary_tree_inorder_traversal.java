/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example
    Given binary tree {1,#,2,3},

       1
        \
         2
        /
       3

    return [1,3,2].
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
    1. Recursive method:
       First, traverse the left subtree recursively. 
       Second, add the root value.
       Last, traverse the right subtree recursively.
    2. Iterative method:
*/

// recursive
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
    
    private void traverse(TreeNode root, ArrayList<Integer> result) {
        if(root == null) return;
        traverse(root.left, result);
        result.add(root.val);
        traverse(root.right, result);
    }
}

// iterative
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return null;
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        while(!s.isEmpty() || root != null) {
            if(root != null) {
                s.push(root);
                root = root.left;
            } else {
                TreeNode node = s.pop();
                result.add(node.val);
                root = node.right;
            }
        }
        return result;
    }
}
