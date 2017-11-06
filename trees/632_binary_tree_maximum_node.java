/*
Find the maximum node in a binary tree, return the node.

Example
    Given a binary tree:
         1
       /   \
     -5     2
     / \   /  \
    0   3 -4  -5 
    return the node with value 3.
*/

/*
Thought process:
    In order to find the maximum node, we need to traverse the binary tree.
    1. Recursive solution:   
	   Base case: return null if the current node is null.
    	   Recursive steps: do an inorder traversal, return the max node at each recursion. 
    2. Iterative solution: 
	   Do a level-order traversal using a queue. Update the max node in each iteration.
*/

// recursive
public class Solution {
    public TreeNode maxNode(TreeNode root) {
        if (root == null) return null;
        TreeNode left = maxNode(root.left);
        TreeNode right = maxNode(root.right);
        return max(root, max(left, right));
    }

    private TreeNode max(TreeNode a, TreeNode b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.val > b.val) {
            return a;
        } else {
            return b;
        }
    }
}

// iterative
public class Solution {
    public TreeNode maxNode(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        TreeNode maxNode = new TreeNode(Integer.MIN_VALUE);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
		    q.offer(node.left);
		}
                if (node.right != null) {
		    q.offer(node.right);
		}
                if (node.val > maxNode.val) {
		    maxNode = node;
		}
            }
        }
        return maxNode;
    }
}
