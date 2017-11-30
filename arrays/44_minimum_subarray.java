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

// O(n) time and O(n) space - DP
public class Solution {
    public int minSubArray(List<Integer> nums) {
        int[] dp = new int[nums.size()];
        dp[0] = nums.get(0);
        int min = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            dp[i] = Math.min(nums.get(i), dp[i-1]+nums.get(i));
            if (dp[i] < min) {
                min = dp[i];
            }
        }
        return min;
    }
}

// O(n) time and O(1) space - Kadane's algorithm (greedy)
public class Solution {
    public int minSubArray(List<Integer> nums) {
        int minSofar = nums.get(0), min = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            minSofar = Math.min(minSofar+nums.get(i), nums.get(i));
            if (minSofar < min) {
		min = minSofar;
	    }
        }
        return min;
    }
}
