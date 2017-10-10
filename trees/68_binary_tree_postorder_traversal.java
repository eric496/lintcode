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
    1. DFS:
           Base case: return if current node is null
           Recursive steps: run recursively on the left child first and then the right child, add the value of the current node 
    2. Iterative method using stack:
           Reverse operations of preorder traversal.
*/

// recursive
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        dfs(root, result);
        return result;
    }
    
    private void traverse(TreeNode node, ArrayList<Integer> result) {
        if(node == null) return;
        traverse(node.left, result);
        traverse(node.right, result);
        result.add(node.val);
    }
}

// iterative
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> s = new ArrayDeque<>();
        TreeNode node = root;
        while(!s.isEmpty() || node != null) {
            if(node != null) {
                s.push(node);
                result.addFirst(node.val);     // Reverse the process of preorder
                node = node.right;             // Reverse the process of preorder
            } else {
                node = s.pop();
                node = node.left;              // Reverse the process of preorder
            }
        }
        return result;
    }
}
