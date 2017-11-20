/*
Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if length of the rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)

Example
    length   | 1   2   3   4   5   6   7   8  
    --------------------------------------------
    price    | 1   5   8   9  10  17  17  20

    Given price = [1, 5, 8, 9, 10, 17, 17, 20], n = 8
    Return 22 // by cutting in two pieces of lengths 2 and 6

    length   | 1   2   3   4   5   6   7   8  
    --------------------------------------------
    price    | 3   5   8   9  10  17  17  20

    Given price = [3, 5, 8, 9, 10, 17, 17, 20], n = 8
    Return 24 // by cutting in eight pieces of length 1
*/

/*
Thought process:
    DP: Create a dp array to store the max obtainable price given a certain length (which is just the index of the dp array).
        Given length i, we can use a bottom-up approach to calculate dp[i]:
            1) Cutting at length 0, we obtain prices[0] + dp[i-1]; (minus 1 because we include prices[0], so the total length should decrease by 1).
            2) Cutting at length 1, we obtain prices[1] + dp[i-1-1];
            3) Cutting at length 2, we obtain prices[2] + dp[i-2-1];
            4) Cutting at length 3, we obtain prices[3] + dp[i-3-1];
            ...
            i) Cutting at length i-1, we obtain prices[i-1] + dp[0].
        Select the max value from 1) to i) and use it as dp[i].
*/

public class Solution {
    public int cutting(int[] prices, int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, prices[j]+dp[i-j-1]);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
