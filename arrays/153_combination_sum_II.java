/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
Each number in C may only be used once in the combination.

Notice
    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.

Example
    Given candidate set [10,1,6,7,2,1,5] and target 8,
    A solution set is:
    [
      [1,7],
      [1,2,5],
      [2,6],
      [1,1,6]
    ]
*/

/*
Thought process: 
    DFS:
        Similar to 135. Combination Sum. The only difference is to rule out duplicate candidate sequence by if(i != index && num[i] == num[i-1]) 
        We should pass parameter i+1 because each number can be used only once.

    A template for this kind of problems: https://discuss.leetcode.com/category/47/combination-sum 
*/

public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        dfs(result, new ArrayList<Integer>(), num, target, 0);
        return result;
    }
    
    public void dfs(List<List<Integer>> result, List<Integer> curSeq, int[] num, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(curSeq));
        } else if (target > 0) {
            for (int i = index; i < num.length; i++) {
                if (i != index && num[i] == num[i-1]) continue;
                curSeq.add(num[i]);
                dfs(result, curSeq, num, target - num[i], i+1);
                curSeq.remove(curSeq.size()-1);
            }
        }
    }
}
