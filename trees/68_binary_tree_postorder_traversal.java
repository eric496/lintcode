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

/*
Thought process:
    0. What is postorder traversal?
           Traverse the nodes in the tree in left-right-root order.
           For example, 
                        A
                      /   \
                     B     C
                    / \   / \
                   D   F G   H
                  / \     \
                 I   J     K
           The postorder traversal is I-J-D-F-B-K-G-H-C-A.
    1. Recursive solution:
           Base case: return when the current node is null.
           Recursive step: run recursively on the left child first and then the right child, add the current node value to result list. 
    2. Iterative solution:
           Reverse the process of preorder traversal. Preorder traversal is in root-left-right order, and postorder traversal is left-right-root, which can be achieved by 
           a slight change of preorder to become root-right-left and then reverse the result list to obtain left-right-root.
           Notice this returns the correct result list but it is actually not a correct postorder "traversal". 
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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }
    
    private void dfs(TreeNode node, List<Integer> result) {
        if (node == null) return;
        dfs(node.left, result);
        dfs(node.right, result);
        result.add(node.val);
    }
}

// iterative method 1
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            result.add(node.val);
            if (node.left != null) {
                s.push(node.left);
            }
            if (node.right != null) {
                s.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}

// iterative method 2
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> s = new ArrayDeque<>();
        TreeNode node = root;
        while (!s.isEmpty() || node != null) {
            // reverse the process of preorder traversal
            if (node != null) {
                s.push(node);
                result.addFirst(node.val); 
                node = node.right;        
            } else {
                node = s.pop();
                node = node.left;        
            }
        }
        return result;
    }
}
