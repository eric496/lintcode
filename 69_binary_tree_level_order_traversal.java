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
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        int maxLevel = 0;
        while(true) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            dfs(root, level, 0, maxLevel);
            if(level.size() == 0) break;
            result.add(level);
            maxLevel++;
        }
       return result;
    }
    
    private void dfs(TreeNode root, ArrayList<Integer> level, int curtLevel, int maxLevel) {
        if(root == null || curtLevel > maxLevel) return;
        if(curtLevel == maxLevel) {
            level.add(root.val);
            return;
        }
        dfs(root.left, level, curtLevel + 1, maxLevel);
        dfs(root.right, level, curtLevel + 1, maxLevel);
    }
}
