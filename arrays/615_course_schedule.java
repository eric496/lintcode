/*
There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example
    Given n = 2, prerequisites = [[1,0]]
    Return true
    Given n = 2, prerequisites = [[1,0],[0,1]]
    Return false
*/

/*
Thought process: 
    1. BFS (Topological sort)
    2. DFS (Find circle)
*/

// BFS (Topological Sort)
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++) map.put(i, new ArrayList<Integer>());
        for(int i = 0; i < prerequisites.length; i++) {
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.offer(i);
        }
        int count = numCourses;
        while(!q.isEmpty()) {
            int course = q.poll();
            for(int i : map.get(course)) {
                if(--indegree[i] == 0) q.offer(i);
            }
            count--;
        }
        return count == 0;
    }
}
