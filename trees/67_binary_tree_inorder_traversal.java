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

/*
Thought process:
    0. What is inorder traversal?
           Traverse the nodes in the tree in left-root-right order.
           For example, 
                        A
                      /   \
                     B     C
                    / \   / \
                   D   F G   H
                  / \     \
                 I   J     K
           The inorder traversal is I-D-J-B-F-A-G-K-C-H.
    1. Recursive solution: 
           Base case: return when current node is null
           Recursive step: run recursively on the left subtree first, add the node value to result list, then run recursively on the right subtree.
    2. Iterative solution:
           Iteratively push each left node into the stack until it reaches a leaf, where node is null.
           Once the current node is null, it is a leaf node. Pop it and add it to result list and let the pointer point to its right child.   
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

// recursive
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
       	dfs(root, result);
        return result;
    }
    
    private void traverse(TreeNode root, List<Integer> result) {
        if (root == null) return;
        dfs(root.left, result);
        result.add(root.val);
        dfs(root.right, result);
    }
}

// iterative using stack
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        while (!s.isEmpty() || node != null) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                node = s.pop();
		// add the node to result list before redirecting the pointer to its right child
                result.add(node.val);
                node = node.right;   
            }
        }
        return result;
    }
}
