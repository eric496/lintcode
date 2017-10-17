/*
Given a set of distinct integers, return all possible subsets.

Notice
    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.

Example
    If S = [1,2,3], a solution is:
    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]

Challenge
    Can you do it in both recursively and iteratively?
*/

// backtracking
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}

// bit manipulation
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
    	int totalNumber = 1 << nums.length;
    	List<List<Integer>> collection = new ArrayList<List<Integer>>(totalNumber);
    	for (int i = 0; i < totalNumber; i++) {
    	    List<Integer> set = new LinkedList<Integer>();
    	    for (int j = 0; j < nums.length; j++) {
    		if ((i & (1 << j)) != 0) set.add(nums[j]);
    	    }
    	    collection.add(set);
    	}
    	return collection;
    }
}
