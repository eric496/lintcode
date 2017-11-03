/*
There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example
    Given n = 2, prerequisites = [[1,0]]
    Return [0,1]
    Given n = 4, prerequisites = [1,0],[2,0],[3,1],[3,2]]
    Return [0,1,2,3] or [0,2,1,3]
*/

// BFS, but it raises TLE
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return null;
        int[] indegree = new int[numCourses];
        int[] order = new int[numCourses];
        int index = 0;
        for (int i = 0; i < prerequisites.length; i++) {
	    indegree[prerequisites[i][0]]++;
	}
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                order[index++] = i;
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int course = q.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == course) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        order[index++] = prerequisites[i][0];
                        q.offer(prerequisites[i][0]);
                    }
                }
            }
        }
        return (index == numCourses) ? order : new int[0];
    }
}
