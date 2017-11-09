/*
Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example
    Given a binary search Tree {5,2,13}:
              5
            /   \
           2     13
    Return the root of new tree
             18
            /   \
          20     13
*/

/*
Thought process:
    It is easy to think of using recursion given a tree structure. Notice this is not simply a tree but also a BST. For each sub-structure like:
         A
        / \ 
       B   C
    B < A < C, so after convert it to a greater tree, it becomes:
         A+C
        /   \
     A+B+C   C
    The right child does not change, while root = root + right, and left = left + root + right. We can reverse inorder traversal (left-root-right -> right-root-left) to do the recursion.

    Recursive solution: 		
        Base case: return null if current node is null
        Recursive step: run recursively on the right subtree, 
                        update the node value by adding the sum of all its right children,
                        set current sum to the current node value,
                        run recursively on the left subtree.                        
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
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }
}
