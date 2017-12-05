/*
Given n unique integers, number k (1<=k<=n) and target.
Find all possible k integers where their sum is target.

Example
    Given [1,2,3,4], k = 2, target = 5. Return:
    [
      [1,4],
      [2,3]
    ]
*/

/*
Thought process:
    DFS
*/

public class Solution {
    List<List<Integer> > result;
    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        result = new ArrayList<List<Integer>>();
        List<Integer> curList = new ArrayList<>();
        dfs(A, k, target, A.length-1, curList);
        return result;
    }

    public void dfs(int[] A, int k, int target, int index, List<Integer> curList) {
        if (k == 0 && target == 0) {
            result.add(new ArrayList<Integer>(curList));
            return;
        }
        if (k < 0 || target < 0 || index < 0) return;
        dfs(A, k, target, index-1, curList);
        curList.add(A[index]);
        dfs(A, k-1, target-A[index], index-1, curList);
        curList.remove(curList.size()-1);
    }
}
