/*
Invert a binary tree.

Example
      1         1
     / \       / \
    2   3  => 3   2
       /       \
      4         4
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
    1. Recursive solution: 
           Base case: return when current node is null.
           Recursive steps: swap the left and right child. 
                            invert the left child and then the right child.
*/

// recursive - trivial
public class Solution {
    public void invertBinaryTree(TreeNode root) {
        if(root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }
}

// iterative using stack
public class Solution {
    public TreeNode invertBinaryTree(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode node = s.pop();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if(node.left != null) s.push(node.left);
            if(node.right != null) s.push(node.right);
        }
        return root;
    }
}

// BFS using queue
public class Solution {
    public TreeNode invertBinaryTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if(node.left != null) q.offer(node.left);
            if(node.right != null) q.offer(node.right);
        }
        return root;
    }
}
