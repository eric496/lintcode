/*
Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Return all the keys in ascending order.

Example
    If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].
        20
       /  \
      8   22
     / \
    4   12
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

// O(n) time by brute-force iteration
public class Solution {
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.pop();
                if (node.val >= k1 && node.val <= k2) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}

// O(logn) time by recursion
public class Solution {
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> result = new ArrayList<Integer>();
        dfs(root, k1, k2, result);
        return result;
    }

    private void dfs(TreeNode root, int k1, int k2, List<Integer> result) {
        if (root == null) return;
        if (root.val > k1) {
            dfs(root.left, k1, k2, result);
        }
        if (root.val >= k1 && root.val <= k2) {
            result.add(root.val);
        }
        if (root.val < k2) {
            dfs(root.right, k1, k2, result);
        }
    }
}
