/*
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Example
   Given a binary tree as follow:
      1
     / \ 
    2   3
       / \
      4   5
    The maximum depth is 3.
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
    1. Recursive solution: check max depth of left and right subtrees recursively. Get the max and plus one (for the root level).
    2. Iterative solutions: simlilar to 69 (use two stacks for DFS or use queue for BFS)
*/

// recursive
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}

// iterative - DFS with two stacks
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> value = new Stack<Integer>();
        stack.push(root);
        value.push(1);
        int max = 0;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int temp = value.pop();
            max = Math.max(temp, max);
            if(node.left != null) {
                stack.push(node.left);
                value.push(temp + 1);
            }
            if(node.right != null) {
                stack.push(node.right);
                value.push(temp + 1);
            }
        }
        return max;
    }
}

// iterative - BFS with queue
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            count++;
        }
        return count;
    }
}
