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
    1. Recursive solution:
           Base case: return true if both T1 and T2 are the same.
           Recursive step: recursively check the equality of T1's left, right children and T2.
    2. Iterative solution:
           Similar to binary tree preorder traversal using a stack. Add nodes to result StringBuffer, 
           append a ",#" after each leaf node in order to handle same node values but different tree structures.
*/

// recursive
public class Solution {
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        if (T2 == null) return true;
        if (T1 == null) return false;
        if (isSame(T1, T2)) return true;
        if (isSubtree(T1.left, T2) || isSubtree(T1.right, T2)) return true;
        return false;
    }

    private boolean isSame(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 == null) return true;
        if (T1 == null || T2 == null) return false;
        if (T1.val != T2.val) return false;
        return isSame(T1.left, T2.left) && isSame(T1.right, T2.right);
    }
}

// iterative 
public class Solution {
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        String t1 = genPreorder(T1); 
        String t2 = genPreorder(T2);
        return t1.contains(t2) ;
    }
    
    private String genPreorder(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()){
           TreeNode node = stack.pop();
            if (node == null) {
                sb.append(",#");
            } else {      
                sb.append("," + node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return sb.toString();
    }
}
