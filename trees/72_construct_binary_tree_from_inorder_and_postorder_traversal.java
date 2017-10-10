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
    
*/

// 
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length) return null;
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    public TreeNode build(int [] preorder, int preLow, int preHigh, int[] inorder, int inLow, int inHigh){
        if(preLow > preHigh || inLow > inHigh) return null;
        TreeNode root = new TreeNode(preorder[preLow]);
        int inorderRoot = inLow;
        for(int i = inLow;i <= inHigh; i++) {
            if(inorder[i] == root.val) {
                inorderRoot = i; 
                break;
            }
        }
        int leftTreeLen = inorderRoot - inLow;
        root.left = build(preorder, preLow+1, preLow+leftTreeLen, inorder, inLow, inorderRoot-1);
        root.right = build(preorder, preLow+leftTreeLen+1, preHigh, inorder, inorderRoot+1, preHigh);       
        return root;        
    }
}
