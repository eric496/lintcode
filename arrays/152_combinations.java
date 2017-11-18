/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example
    If n = 4 and k = 2, a solution is:
    [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
*/

/*
Thought process:
    DFS: 
*/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n <= 0 || k <= 0) return result;
        List<Integer> curSeq = new ArrayList<Integer>();
        dfs(result, curSeq, n, k, 1);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> curSeq, int n, int k, int index) {
        if (curSeq.size() == k) {
            result.add(new ArrayList<Integer>(curSeq));
            return;
        }
        for (int i = index; i <= n; i++) {
            curSeq.add(i);
            dfs(result, curSeq, n, k, i+1);
            curSeq.remove(curSeq.size()-1);
        }
    }
}
