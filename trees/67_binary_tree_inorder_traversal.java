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
    1. DFS: 
           Base case: return when current node is null
           Recursive steps: run recursively on the left child first, 
                            add the value of the current node to the result list, 
                            run recursively on the right child.
    2. Iterative solution using stack:
               
*/

// recursive
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
       	dfs(root, result);
        return result;
    }
    
    private void traverse(TreeNode root, ArrayList<Integer> result) {
        if(root == null) return;
        dfs(root.left, result);
        result.add(root.val);
        dfs(root.right, result);
    }
}

// iterative
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode node = root;
        while(!s.isEmpty() || node != null) {
            if(node != null) {
                s.push(node);
                node = node.left;
            } else {
                node = s.pop();
                result.add(node.val);    // Add after all left children
                node = node.right;   
            }
        }
        return result;
    }
}
