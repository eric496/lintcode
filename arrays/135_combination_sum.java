/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.

Notice
    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.

Example
    Given candidate set [2,3,6,7] and target 7, a solution set is:
    [7]
    [2, 2, 3]
*/

/*
Thought process:
    DFS: Sort the array first. Pass in result list, sub result list, array, target, and search start index.
         If target is 0, it means we have found one sub result list, then add it to the result list. 
         If target is not 0, iterate the array from the current start index. 
             If current element is greater than target, break the loop (because following elements are all greater given the array is sorted)
             Add the current element to the sub result list. Run recursively using the target minus the current element. 
             Remove the last sub result list because target is always 0 in the last recursion and we add an empty sub result list in the last run.
*/

// O(2^n) time and O(1) space
public class Solution {
    public List<List<Integer>> combinationSum(int[] num, int target) {
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
                if (target < num[i]) break;
                curSeq.add(num[i]);
                dfs(result, curSeq, num, target-num[i], i);
                curSeq.remove(curSeq.size()-1);
            }
        }
    }
}
