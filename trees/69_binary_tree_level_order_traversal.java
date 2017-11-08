/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

Example
    Given binary tree {3,9,20,#,#,15,7},

        3
       / \
      9  20
        /  \
       15   7

    return its level order traversal as:
    [
      [3],
      [9,20],
      [15,7]
    ]

Challenge
    Challenge 1: Using only 1 queue to implement it.
    Challenge 2: Use DFS algorithm to do it.
*/

/*
Thought process:
    1. Recursive solution: 
           Observe that each sub list represents a tree level. 
           Base case: return when current node is null.  
           Recursive step: if current level is greater than or equals to the size of result list which means it comes to a new level, then add a new sub list to store node values on the current level. 
                           Recursively run on the left subtree first and then the right with level incremented by one at each recursion call. 
    2. Iterative:
           Push the root to the queue. Iterate the queue as long as it is not empty, create a new sub list in each iteration to store node values on the current level. 
           Pop the top node from the queue, add its value to the sub list. Push its left and then its right child into the queue.
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, root, 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, TreeNode node, int level) {
        if (node == null) return;
        if (level >= result.size()) {
	    result.add(new ArrayList<Integer>());
	}
        result.get(level).add(node.val);
        dfs(result, node.left, level+1);
        dfs(result, node.right, level+1);
    }
}

// iterative
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                curLevel.add(node.val);
                if (node.left != null) {
		    q.offer(node.left);
		}
                if (node.right != null) {
		    q.offer(node.right);
		}
            }
            result.add(curLevel);
        }
        return result;
    }
}
