/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Notice
    You may assume that duplicates do not exist in the tree.

Example
    Given in-order [1,2,3] and pre-order [2,1,3], return a tree:
      2
     / \
    1   3
*/

/*
Thought process:
    Preorder traversal implies that the preorder[0] is the root, then we look for the same value in the inorder array to which the left part is the left subtree, and the right part is the right subtree.
    1. Recursive solution:
           Base case: return null when index of the low end is greater than that of the high end.
           Recursive step: set the first node in the current preorder array as root node, find the same value in the inorder array.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    public TreeNode build(int[] preorder, int preLow, int preHigh, int[] inorder, int inLow, int inHigh){
        if (preLow > preHigh || inLow > inHigh) return null;
        // the last element in postorder is the root
        TreeNode root = new TreeNode(preorder[preLow]);
        // find the index of the root from inorde
        int inRootIndex = inLow;
        for (int i = inLow; i <= inHigh; i++) {
            if (inorder[i] == root.val) {
                inRootIndex = i; 
                break;
            }
        }
        int leftTreeLen = inRootIndex - inLow;
        root.left = build(preorder, preLow+1, preLow+leftTreeLen, inorder, inLow, inRootIndex-1);
        root.right = build(preorder, preLow+leftTreeLen+1, preHigh, inorder, inRootIndex+1, preHigh);       
        return root;        
    }
}

// iterative
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        Stack<TreeNode> s = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]), cur = root;
        for (int i = 1, j = 0; i < preorder.length; i++) {
            if (cur.val != inorder[j]) {
                cur.left = new TreeNode(preorder[i]);
                s.push(cur);
                cur = cur.left;
            } else {
                j++;
                while (!s.empty() && s.peek().val == inorder[j]) {
                    cur = s.pop();
                    j++;
                }
                cur = cur.right = new TreeNode(preorder[i]);
            }
        }
        return root;
    }
}
