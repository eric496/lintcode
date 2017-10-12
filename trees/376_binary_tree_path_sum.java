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
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (root == null) return result;
    	ArrayList<Integer> path = new ArrayList<Integer>();
    	path.add(root.val);
    	traversal(result, path, root, root.val, target);
    	return result;
    }

    public void traversal(List<List<Integer>> result, ArrayList<Integer> path, TreeNode node, int currentSum, int target) {
    	if (node.left == null && node.right == null) {
    	    if(currentSum == target) result.add(new ArrayList<Integer>(path));
    	    return;
    	}
    	if (node.left != null) {
    	    path.add(node.left.val);
    	    traversal(result, path, node.left, currentSum + node.left.val, target);
    	    path.remove(path.size() - 1);
    	}
    	if (node.right != null) {
    	    path.add(node.right.val);
    	    traversal(result, path, node.right, currentSum + node.right.val, target);
    	    path.remove(path.size() - 1);
    	}
    }
}
