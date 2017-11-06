/*
In a binary search tree, (Only) two nodes are swapped. Find out these nodes and swap them. If there no node swapped, return original root of tree.

Example
    Given a binary search tree:
        4
       / \
      5   2
     / \
    1   3
    return
        4
       / \
      2   5
     / \
    1   3
*/

public class Solution {
    public TreeNode bstSwappedNode(TreeNode root) {
        TreeNode pre = null;
        TreeNode first = null, second = null;
        // Morris Traversal
        TreeNode temp = null;
        TreeNode dummy = new TreeNode(-1);
        dummy = root;
        while (root != null){
            if (root.left != null) {
                // connect threading for root
                temp = root.left;
                while (temp.right!=null && temp.right != root) {
                    temp = temp.right;
                }
                // the threading already exists
                if (temp.right!=null) {
                    if (pre != null && pre.val > root.val) {
                        if (first == null) {
                            first = pre;second = root;
                        } else {
                            second = root;
                        }
                    }
                    pre = root;
                    temp.right = null;
                    root = root.right;
                } else {
                    // construct the threading
                    temp.right = root;
                    root = root.left;
                }
            } else {
                if (pre!=null && pre.val > root.val) {
                    if (first == null) {
                        first = pre;second = root;
                    } else {
                        second = root;
                    }
                }
                pre = root;
                root = root.right;
            }
        }
        // swap two node values;
        if (first != null && second != null) {
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
        return dummy;
    }
}
