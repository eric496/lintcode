/*
Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.
A valid path is from root node to any of the leaf nodes.

Example
    Given a binary tree, and target = 5:
         1
        / \
       2   4
      / \
     2   3
    return
    [
      [1, 2, 2],
      [1, 4]
    ]
*/

/*
Thought process:
    Recursive solution:
        Base case: return null when current node is null.
        Recursive step: if current node is a leaf node and match the current target value, then add its path to result list.
                        Otherwise, recursively search its left and right subtrees.
                        Remember to remove the last node value in the path at the end in order to backtrack.
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

// DFS
public class Solution {
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>(); 
        dfs(root, target, path, result);
        return result;
    }
    
    public void dfs(TreeNode root, int target, List<Integer> path, List<List<Integer>> result){
        if (root == null) return; 
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == target) {
            result.add(new ArrayList(path));
        } else {
            dfs(root.left, target-root.val, path, result);
            dfs(root.right, target-root.val, path, result);
        }
        path.remove(path.size()-1);
    }
}
