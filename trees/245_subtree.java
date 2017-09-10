/*
You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes. 
Create an algorithm to decide if T2 is a subtree of T1.

Notice
    A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2. That is, if you cut off the tree at node n, the two trees would be identical.

Example
    T2 is a subtree of T1 in the following case:
           1                3
          / \              / 
    T1 = 2   3      T2 =  4
            /
           4
    T2 isn't a subtree of T1 in the following case:
           1               3
          / \               \
    T1 = 2   3       T2 =    4
            /
           4
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
    1. Recursive solution
*/

public class Solution {
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        if (T2 == null) return true;
        if (T1 == null) return false;
        if (isEqual(T1, T2)) return true;
        if (isSubtree(T1.left, T2) || isSubtree(T1.right, T2)) return true;
        return false;
    }

    private boolean isEqual(TreeNode T1, TreeNode T2) {
        if (T1 == null || T2 == null) return T1 == T2;
        if (T1.val != T2.val) return false;
        return isEqual(T1.left, T2.left) && isEqual(T1.right, T2.right);
    }
}
