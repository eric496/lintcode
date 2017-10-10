/*
Check if two binary trees are identical. 
Identical means the two binary trees have the same structure and every identical position has the same value.

Example
        1             1
       / \           / \
      2   2   and   2   2
     /             /
    4             4
    are identical.
        1             1
       / \           / \
      2   3   and   2   3
     /               \
    4                 4
    are not identical.
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
           Base case: return true when both nodes are null.
           Recursive steps: check equality of the left subtrees and the right subtrees. 
    2. Iterative solution: (BFS)
           Push the nodes from two trees into two stacks, 
           check if the popped nodes are equal. 
           Return false if a child of one node is null while that of the other node is not null.
*/

// recursive
public class Solution {
    public boolean isIdentical(TreeNode a, TreeNode b) {
        if(a == null && b == null) return true;
        if(a != null && b != null) {
            if(a.val == b.val)
                return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
        }
        return false;
    }
}

// iterative using two stacks
public class Solution {
    public boolean isIdentical(TreeNode a, TreeNode b) {
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(a);
        s2.push(b);
        while(!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode n1 = s1.pop();
            TreeNode n2 = s2.pop();
            if(n1.val != n2.val) return false;
            if(n1.left != null && n2.left != null) {
                s1.push(n1.left);
                s2.push(n2.left);    
            } else if(n1.left != null || n2.left != null) {
                return false;
            }
            if(n1.right != null && n2.right != null) {
                s1.push(n1.right);
                s2.push(n2.right);   
            } else if(n1.right != null || n2.right != null) {
                return false;
            }
        }
        return true;
    }
}
