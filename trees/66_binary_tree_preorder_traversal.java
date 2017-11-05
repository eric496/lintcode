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
    0. What is preorder traversal?
           Traverse the nodes in the tree in root-left-right order.
           For example, 
			A
		      /   \
		     B     C
		    / \   / \
		   D   F G   H
		  / \     \
		 I   J     K
           The preorder traversal is A-B-D-I-J-F-C-G-K-H.
    1. Recursive solution: 
           Base case: return when current node is null
           Recursive step: add the value of the current node to the result list, run recursively on the left subtree first and then the right.
    2. Iterative solution:
           Push root into the stack, As long as the stack is not empty, iteratively pop the top node in the stack, add its value to the result list.
           Push its RIGHT child first, then its left child into the stack.
       	   Stack is a LIFO data structure, so we need to push right child before the left in order to pop the left first then the right for preorder manner.
*/

// recursive solution
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {    
        ArrayList<Integer> result = new ArrayList<Integer>();
        dfs(root, result);
        return result;
    }
    
    private void dfs(TreeNode root, ArrayList<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        dfs(root.left, result);
        dfs(root.right, result);
    }
}

// iterative solution 1
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return null;
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            result.add(node.val);
            if (node.right != null) {
		s.push(node.right);
	    }
            if (node.left != null) {
		s.push(node.left);
	    }
        }
        return result;
    }
}

// iterative solution 2
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        while (!s.isEmpty() || node != null) {
            if (node != null) {
                s.push(node);
                result.add(node.val);    // Add before going to children
                node = node.left;
            } else {
                node = s.pop();
                node = node.right;   
            }
        }
        return result;
    }
}
