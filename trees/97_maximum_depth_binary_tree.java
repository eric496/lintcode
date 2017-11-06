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
    1. Recursive solution: 
           Base case: return 0 when current node is null.
           Recursive step: run recursively on the left and the right children of the current node, 
                           return the larger value PLUS ONE
    2. Iterative solution: 
           BFS: Similar to level order traversal, with a count variable to keep the number of levels.
           DFS: Use two stacks, push each node into stack s, meanwhile push the current number of levels into stack v,
                At each iteration, update the max depth. 
           
*/

// recursive
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

// iterative - DFS using two stacks
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<Integer> v = new Stack<Integer>();
        s.push(root);
        v.push(1);
        int max = 1;
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            int height = v.pop();
            max = Math.max(height, max);
            if (node.left != null) {
                s.push(node.left);
                v.push(height + 1);
            }
            if (node.right != null) {
                s.push(node.right);
                v.push(height + 1);
            }
        }
        return max;
    }
}

// iterative - BFS using queue
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int max = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
		    q.offer(node.left);
		}
                if (node.right != null) {
		    q.offer(node.right);
		}
            }
            max++;
        }
        return max;
    }
}
