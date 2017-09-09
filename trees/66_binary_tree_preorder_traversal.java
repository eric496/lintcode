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

/*
Thought process:
    1. Recursive solution 
    2. Iterative solution using stack
       push root -> while stack not empty -> pop item and add to result list -> push right child -> push left child
       Notice stack is LIFO, so for preorder traversal, we need to push right child first then the left.
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
        if(root == null) return null;
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode cur = s.pop();
            result.add(cur.val);
            if(cur.right != null) s.push(cur.right);
            if(cur.left != null) s.push(cur.left);
        }
        return result;
    }
}
