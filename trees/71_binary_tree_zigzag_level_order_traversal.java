/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

Example
    Given binary tree {3,9,20,#,#,15,7},
        3
       / \
      9  20
        /  \
       15   7
    return its zigzag level order traversal as:
    [
      [3],
      [20,9],
      [15,7]
    ]
*/

/*
Thought process:
    1. Use queue to store each level. 
    2. Use a flag variable to switch forward and backward traversal for each level.
       In this question, if order = true then add append element. Otherwise, insert at the head.
    3. Pop each element, add its value to the list. At the same time, add its children 
       to the queue.
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        boolean order = true;
        while(!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(order) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            order = !order;
            result.add(level);
        }
        return result;
    }
}
 
