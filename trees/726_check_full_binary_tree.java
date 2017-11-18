/*
A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes. Conversely, there is no node in a full binary tree, which has one child node. More information about full binary trees can be found here.

Full Binary Tree
      1
     / \
    2   3
   / \
  4   5

Not a Full Binary Tree
      1
     / \
    2   3
   / 
  4   

Example
    Given tree {1,2,3}, return true
    Given tree {1,2,3,4}, return false
    Given tree {1,2,3,4,5} return true
*/

/*
Thought process:
    Recursive solution: 
        Base case: Return true when the left and right subtrees are both null. 
                   Otherwise, return false if any subtree is null while the other is not.
        Recursive step: Run recursively on the left subtree and the right subtree.
*/

public class Solution {
    public boolean isFullTree(TreeNode root) {
        if (root.left == null && root.right != null) return false;
        if (root.left != null && root.right == null) return false;
        if (root.left == null && root.right == null) return true;
        return isFullTree(root.left) && isFullTree(root.right);
    }
}
