/*
Given a directed graph, design an algorithm to find out whether there is a route between two nodes.

Example
    Given graph:
    A----->B----->C
     \     |
      \    |
       \   |
        \  v
         ->D----->E
    for s = B and t = E, return true
    for s = D and t = C, return false
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */

public class Solution {
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
        if (s == t) return true;
        HashSet<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        queue.offer(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (int i = 0; i < node.neighbors.size(); i++) {
                if (visited.contains(node.neighbors.get(i))) continue;
                visited.add(node.neighbors.get(i));
                queue.offer(node.neighbors.get(i));
                if (node.neighbors.get(i) == t) return true;
            }
        }
        return false;
    }
}
