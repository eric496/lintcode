/*
Given a list of numbers that may has duplicate numbers, return all possible subsets

Notice
    Each element in a subset must be in non-descending order.
    The ordering between two subsets is free.
    The solution set must not contain duplicate subsets.

Example
    If S = [1,2,2], a solution is:
    [
      [2],
      [1],
      [1,2,2],
      [2,2],
      [1,2],
      []
    ]

Challenge
    Can you do it in both recursively and iteratively?
*/

// backtracking
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    } 
}

// iterative
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<Integer>());
        int size = 0, startIndex;
        for(int i = 0; i < nums.length; i++) {
            startIndex = (i >= 1 && nums[i] == nums[i - 1]) ? size : 0;
            size = ret.size();
            for(int j = startIndex; j < size; j++) {
                List<Integer> temp = new ArrayList<>(ret.get(j));
                temp.add(nums[i]);
                ret.add(temp);
            }
        }
        return ret;
    } 
}
