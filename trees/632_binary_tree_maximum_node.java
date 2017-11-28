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
        return max(root, max(maxNode(root.left), maxNode(root.right)));
    }
    
    private TreeNode max(TreeNode node1, TreeNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        if (node1.val > node2.val) {
            return node1;
        } else {
            return node2;
        }
    }
}

// iterative
public class Solution {
    public TreeNode maxNode(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode maxNode = new TreeNode(Integer.MIN_VALUE);
        while (!q.isEmpty()) {
            int size = q.size()
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
