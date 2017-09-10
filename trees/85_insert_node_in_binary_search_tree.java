/*
Given a binary search tree and a new tree node, insert the node into the tree. You should keep the tree still be a valid binary search tree.

Notice
    You can assume there is no duplicate values in this tree + node.

Example
    Given binary search tree as follow, after Insert node 6, the tree should be:
      2             2
     / \           / \
    1   4   -->   1   4
       /             / \ 
      3             3   6
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
    1. Recursive solution: if greater than value of the root, then recursely insert into the right subtree. Ohterwise, the left.
    2. Iterative solution: create a runner and loop through the tree to insert the node. 
*/
 
// recursive solution
public class Solution {
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if(root == null) return node;
        if(root.val < node.val) {
            root.right = insertNode(root.right, node);
        } else {
            root.left = insertNode(root.left, node);
        }
        return root;
    }
}

// iterative solution
public class Solution {
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if(node == null) return root;
        if(root == null) return node;
        TreeNode runner = root;
        while(runner != null) {
            if(node.val >= runner.val && runner.right == null) {
                runner.right = node;
                break;
            } else if(node.val < runner.val && runner.left == null) {
                runner.left = node;
                break;
            } else if(node.val >= runner.val) {
                runner = runner.right;
            } else if(node.val < runner.val) {
                runner = runner.left;
            }
        }
        return root;
    }
}
