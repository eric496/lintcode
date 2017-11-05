/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Notice
    You may assume that duplicates do not exist in the tree.

Example
    Given inorder [1,2,3] and postorder [1,3,2], return a tree:
      2
     / \
    1   3
*/

/*
Thought process:
    1. Recursive solution: 
           Basic idea: the last node in the postorder array is the root, look for the same value in the inorder array, to which all left elements are the left subtree and all right elements are the right subtree 
           Base case: return null if index of the low end is greater than that of the high end for inorder array.
           Recursive step: take the last element in the postorder array as the current root. Find the same value in the inorder array. 
                           Recursively build the left and then the right subtrees.
    2. Iterative solution:
            
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

// recursive
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length != inorder.length) return null;
        return build(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
    }
    
    private TreeNode build(int[] postorder, int postLow, int postHigh, int[]inorder, int inLow, int inHigh) {
        if (inLow > inHigh) return null;
        // the last element in postorder is the root.
        TreeNode root = new TreeNode(postorder[postHigh]);
        // find the index of the root from inorder.
        int inIndex = inLow;
        for (int i = inLow; i <= inHigh; i++) {
            if (inorder[i] == postorder[postHigh]) {
                inIndex = i;
                break;
            }
        }
        // build the right and left subtrees. Again, scanning from the end to find the sections.
        int leftTreeLen = inIndex - inLow;
        root.left = build(postorder, postLow, postLow+leftTreeLen-1, inorder, inLow, inIndex-1);
        root.right = build(postorder, postLow+leftTreeLen, postHigh-1, inorder, inIndex+1, inHigh);
        return root;
    }
}

// iterative  
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        int inIndex = inorder.length - 1;
        int postIndex = postorder.length - 1;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode root = new TreeNode(postorder[postIndex]);
        s.push(root);
        postIndex--;
        while (postIndex >= 0) {
            while (!s.isEmpty() && s.peek().val == inorder[inIndex]) {
                prev = s.pop();
                inIndex--;
            }
            TreeNode node = new TreeNode(postorder[postIndex]);
            if (prev != null) {
                prev.left = node;
            } else if (!s.isEmpty()) {
                TreeNode topNode = s.peek();
                topNode.right = node;
            }
            s.push(node);
            prev = null;
            postIndex--;
        }
        return root;
    }
}

