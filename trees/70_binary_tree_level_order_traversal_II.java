/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

Example
    Given binary tree {3,9,20,#,#,15,7},
        3
       / \
      9  20
        /  \
       15   7
    return its bottom-up level order traversal as:
    [
      [15,7],
      [9,20],
      [3]
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
    Traverse in top-down order and reverse the result.
*/

// recursive
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        dfs(root, result, 0);
        Collections.reverse(result);
        return result;
    }

    private void dfs(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) return;
        if (level >= result.size()) {
	    result.add(new ArrayList<Integer>());
	}
        result.get(level).add(node.val);
        dfs(node.left, result, level+1);
        dfs(node.right, result, level+1);
    }
}

// iterative
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
		    queue.offer(node.left);
		}
                if (node.right != null) {
		    queue.offer(node.right);
		}
            }
            result.add(0, level);
        }
        return result;
    }
}
