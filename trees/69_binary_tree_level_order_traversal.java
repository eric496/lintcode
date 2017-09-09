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
    1. Recursive solution: use DFS. If current level is greater than or equals to the result size, 
       add a new array list to store the values from the new level. Recursively loop through the 
       left and right subtrees. 
    2. Iterative solution: use a queue.
*/

// recursive with DFS
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

// iterative (BFS) using queue
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int levelCount = q.size();
            for(int i = 0; i < levelCount; i++) {
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                level.add(q.poll().val);
            }
            result.add(level);
        }
        return result;
    }
}
