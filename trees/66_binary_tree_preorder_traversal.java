/*
Given a binary tree, return the preorder traversal of its nodes' values.

Example
    Given:
        1
       / \
      2   3
     / \
    4   5
    return [1,2,4,5,3].
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

// recursive solution
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {    
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
    
    private void traverse(TreeNode root, ArrayList<Integer> result) {
        if(root == null) return;
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }
}

// iterative solution
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {    
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) return result;
        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
