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

/*
Thought process:
    1. Recursive solution:
           Base case: return when current node is null.
           Recursive step: (bottom up) 
                run recursively on the right subtree and then the left, 
                set a global variable pre, for each iteration, set pre to the right child of the current node, 
                set the left subtree to null, and redirect to the current node.
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

// recursive 1 (bottom-up)
public class Solution {
    private TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}

// recursive 2 (top-down)
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        // save current right for concatination
        TreeNode right = root.right;
        while (root.left != null) {
            // step 1: concatinate root with the left flattened subtree
            root.right = root.left;
            // set left to null
            root.left = null;
            // step 2: move to the end of new added flattened subtree
            while (root.right != null) {
                root = root.right;
            }
            // step 3: concatinate left flattened subtree with flattened right subtree
            root.right = right;
        }
    }
}

// iterative
public class Solution {
    private TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode node = root; 
        while (node != null) {
            if (node.left != null) {
                TreeNode pre = node.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }
}
