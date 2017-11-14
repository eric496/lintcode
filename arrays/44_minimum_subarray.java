/*
Given an array of integers, find the subarray with smallest sum.
Return the sum of the subarray.

Notice
    The subarray should contain one integer at least.
*/

/*
Thought process: 
     Refer to 41. Maximum Subarray
*/

// greedy - Kadane's algorithm
public class Solution {
    public int minSubArray(List<Integer> nums) {
        int minSofar = nums.get(0), globalMin = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            minSofar = Math.min(minSofar + nums.get(i), nums.get(i));
            if (minSofar < globalMin) {
		globalMin = minSofar;
	    }
        }
        return globalMin;
    }
}
