/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
How we serialize an undirected graph:
Nodes are labeled uniquely.
We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.
The graph has a total of three nodes, and therefore contains three parts as separated by #.
    First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
    Second node is labeled as 1. Connect node 1 to node 2.
    Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:
   1
  / \
 /   \
0 --- 2
     / \
     \_/

Example
    return a deep copied graph.
*/

/*
Thought process:
    Use a queue to store all nodes, and use a hashmap to store <original, copy> pairs. 
    Iteratively pop and push node's neighbors into the queue. Iterate all neighbors of the current node, if it exists in hashmap keys, 
    add it to the current copy's neighbors and continue the loop. If it does not exist as a key, add it as a key and create a copy as its value.
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        UndirectedGraphNode rootCopy = new UndirectedGraphNode(node.label);
        map.put(node, rootCopy);
        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            UndirectedGraphNode curCopy = map.get(cur);
            for (UndirectedGraphNode neighbor: cur.neighbors) {
                if (map.containsKey(neighbor)) {
                    curCopy.neighbors.add(map.get(neighbor));
                    continue;
                }
                q.offer(neighbor);
                UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
                curCopy.neighbors.add(neighborCopy);
                map.put(neighbor, neighborCopy);
            }
        }
        return rootCopy;
    }
}
