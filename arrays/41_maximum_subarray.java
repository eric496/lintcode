/*
Given an array of integers, find a contiguous subarray which has the largest sum.

Notice
    The subarray should contain at least one number.

Example
    Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.

Challenge
    Can you do it in time complexity O(n)?
*/

/*
Thought process
    1. DP: The problem can be decomposed to the sub problem that dp[i] represents the largest sum ending at the i-th element.
           dp[i] is either dp[i-1] plus the current element nums[i] or nums[i] itself, whichever is greater.
    2. Greedy - Kadane's algorithm: (same to DP, but even concise because it is not necessary to store dp[i])
            The maximum sum of a contiguous subarray ending at a specific element is either 
                1) the maximum sum of a contiguous subarray ending at its previous element plus the current element, OR
                2) the specific element itself, 
                whichever is greater. 
            Iterate the array, compares each element with max sum of subarray ending at its previous element, 
            update the global maximum with whichever is greater.
*/

// O(n) time and O(n) space by DP
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            if (dp[i] > max) {
		max = dp[i];
	    }
        }
        return max;
    }
}

// O(n) time and O(1) space by Kadane's algorithm
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxSofar = nums[0], globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSofar = Math.max(maxSofar+nums[i], nums[i]);
            if (maxSofar > globalMax) {
		globalMax = maxSofar;
	    }
        }
        return globalMax;
    }
}
