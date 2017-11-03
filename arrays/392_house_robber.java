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
    DP
*/

public class Solution {
    public long houseRobber(int[] A) {
        int n = A.length;
        if (n == 0) return 0;
        long[] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = A[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + A[i-1]);
        }
        return dp[n];
    }
}
