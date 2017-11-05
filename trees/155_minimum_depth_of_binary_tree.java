/*
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Example
    Given a binary tree as follow:
      1
     / \ 
    2   3
       / \
      4   5
    The minimum depth is 2.
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
           Base case: return 0 when current node is null,
                      run recursively on the right subtree when the left subtree is null
                      run recursively on the left subtree when the right subtree is null
           Recursive step: run recursively on the left and the right children, take the smaller value PLUS ONE
    2. Iterative solution: (BFS order level traversal)
           At each iteration, check if the current node has at least one child. If not, it reaches a leaf, and return the current min (number of levels). 
           Otherwise, iterate until it reaches a leaf. Remember to increment min by 1 at each iteration.
*/

// recursive
public class Solution {
    public static int minDepth(TreeNode root) {
        if (root == null)   return 0;
        if (root.left == null)  {
	    return minDepth(root.right) + 1;
	}
        if (root.right == null) {
	    return minDepth(root.left) + 1;
	}
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}

// iterative - BFS using queue
public class Solution {
    public static int minDepth(TreeNode root) {
    	if(root == null) return 0;
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.offer(root);
    	int min = 1;
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
    	        if (node.left == null && node.right == null) return min;
    	    }
            min++;
    	}
    	return min;
    }
}
