/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example
    Given [3, 8, 4], return 8.

Challenge
    O(n) time and O(1) memory.
*/

/*
Thought process:
    1. DP: Create a DP array to store the max money obtainable so far at the current house:
           Whether to rob the current house is a binary decision based on:
               1) dp[i-1] (does not rob the current one, so dp[i] = dp[i-1])
               2) dp[i-2] + A[i-1] (rob the current one, notice the current house is A[i-1] because dp has length n+1)
           whichever is greater.
*/

// method 1
public class Solution {
    public long houseRobber(int[] A) {
        int n = A.length;
        if (n == 0) return 0;
        long[] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = A[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+A[i-1]);
        }
        return dp[n];
    }
}

// method 2
public class Solution {
    public long houseRobber(int[] A) {
        long oddSum = 0, evenSum = 0;
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                oddSum = Math.max(oddSum+A[i], evenSum);
            } else {
                evenSum = Math.max(evenSum+A[i], oddSum);
            }
        }
        return Math.max(oddSum, evenSum);
    }
}
