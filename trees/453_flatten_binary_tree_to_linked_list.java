/*
Flatten a binary tree to a fake "linked list" in pre-order traversal.
Here we use the right pointer in TreeNode as the next pointer in ListNode.

Notice
    Don't forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.

Example
                  1
                   \
         1          2
        / \          \
       2   5    =>    3
      / \   \          \
     3   4   6          4
                         \
                          5
                           \
                            6
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

public class Solution {
    private TreeNode lastNode = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        if(lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }
        lastNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
}

// iterative 
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode curr = stack.pop();
            if (curr.right!=null)  
                 stack.push(curr.right);
            if (curr.left!=null)  
                 stack.push(curr.left);
            if (!stack.isEmpty()) 
                 curr.right = stack.peek();
            curr.left = null;
        }
    }
}
