/*
Given a list of numbers, return all possible permutations.

Notice
    You can assume that there is no duplicate numbers in the list.

Example
    For nums = [1,2,3], the permutations are:
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]

Challenge
    Do it without recursion.
*/

// recursive
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        backtrack(result, nums, new ArrayList<Integer>(), 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, int[] nums, List<Integer> currentList, int index) {
        if (currentList.size() == nums.length) {
            result.add(currentList);
            return;
        }
        int n = nums[index];
        for (int i = 0; i <= currentList.size(); i++) {
            List<Integer> copy = new ArrayList<Integer>(currentList);
            copy.add(i, n);
            backtrack(result, nums, copy, index + 1);
        }
    }
}

// iterative
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length ==0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        List<Integer> l0 = new ArrayList<Integer>();
        l0.add(nums[0]);
        result.add(l0);
        for (int i = 1; i< nums.length; ++i){
            List<List<Integer>> new_res = new ArrayList<List<Integer>>(); 
            for (int j = 0; j <= i; ++j){            
               for (List<Integer> l : result){
            	   List<Integer> new_l = new ArrayList<Integer>(l);
            	   new_l.add(j, nums[i]);
            	   new_res.add(new_l);
               }
            }
            result = new_res;
        }
        return result;
    }
}
