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

Challenge
    Do it in-place without any extra memory.
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
           
    2. Iterative solution:
*/

// recursive 
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        // save current right for concatination
        TreeNode right = root.right;
        while(root.left != null) {
            // step 1: concatinate root with left flatten subtree
            root.right = root.left;
            // set left to null
            root.left = null;
            // step 2: move to the end of new added flatten subtree
            while(root.right != null) root = root.right;
            // step 3: contatinate left flatten subtree with flatten right subtree
            root.right = right;
        }
    }
}

// iterative using stack
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while (!s.isEmpty()){
            TreeNode node = stack.pop();
            if (node.right!=null) s.push(curr.right);
            if (node.left!=null) s.push(curr.left);
            if (!s.isEmpty()) node.right = s.peek();
            node.left = null;
        }
    }
}
