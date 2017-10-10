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
    1. DFS:
           Base case: return when current node is null
           Recursive steps: add the value of the current node to the list,
                            run recursively the left child first and then the right child.
    2. Iterative solution using stack:
           Push root into stack
           Pop the top node in the stack, add its value to the result list
           Push its RIGHT child first, then its left child into the stack
       	   Because stack is a LIFO data structure, we need to push right child before the left in order for preorder traversal.
*/

// recursive solution
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {    
        ArrayList<Integer> result = new ArrayList<Integer>();
        dfs(root, result);
        return result;
    }
    
    private void dfs(TreeNode root, ArrayList<Integer> result) {
        if(root == null) return;
        result.add(root.val);
        dfs(root.left, result);
        dfs(root.right, result);
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
            TreeNode node = s.pop();
            result.add(node.val);
            if(node.right != null) s.push(node.right);
            if(node.left != null) s.push(node.left);
        }
        return result;
    }
}
