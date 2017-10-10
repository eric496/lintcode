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
           Observe that each sub list represents a tree level. 
           Base case: return when current node is null.  
           Recursive steps: if current level is greater than or equals to the result size 
                            which means the current level is a new level, then add a new array list to store the value of the current node. 
                            Recursively run on left child first and then right child with level parameter incremented by 1 at each step. 
    2. BFS:
           Use a queue data structure to solve the problem. 
           Push the root to the queue. 
           Pop the top node from the queue, add it to the sub list. 
           Push its left and right children into the queue. Repeat until the queue is empty.
*/

// DFS
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, root, 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, TreeNode node, int level) {
        if(node == null) return;
        if(level >= result.size()) result.add(new ArrayList<Integer>());
        result.get(level).add(node.val);
        dfs(result, node.left, level+1);
        dfs(result, node.right, level+1);
    }
}

// BFS
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode head = q.poll();
                level.add(head.val);
                if(head.left != null) q.offer(head.left);
                if(head.right != null) q.offer(head.right);
            }
            result.add(level);
        }
        return result;
    }
}
