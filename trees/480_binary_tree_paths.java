/*
Given a binary tree, return all root-to-leaf paths.

Example
    Given the following binary tree:
       1
     /   \
    2     3
     \
      5
    All root-to-leaf paths are:
    [
      "1->2->5",
      "1->3"
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
    1. Recursive solution:
           Base case: return when current node is null.
           Recursive step: add the path to result list if current node has no children (a leaf node).
                           Otherwise, run recursively on the left and the right subtrees.
*/

// recursive
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) return result;
        findPaths(root, String.valueOf(root.val), result);
        return result;
    }

    private void findPaths(TreeNode node, String path, List<String> result) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            result.add(path);
        }
        if (node.left != null) {
            findPaths(node.left, path+"->"+String.valueOf(node.left.val), result);
        }
        if (node.right != null) {
            findPaths(node.right, path+"->"+String.valueOf(node.right.val), result);
        }
    }
}
