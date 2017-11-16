/*
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.

Notice
    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example
    Given an example [4,4,6,1,1,4,2,5], return 6.
*/

/*
Thought process:
    Forward-backward traversal:
        A forward pass calculates the max profit so far to the left; a backward pass calculates the max profit so far to the right.
        Iterate the dp arrays and add both elements at each position. Compare it with max, if it is greater than max, update max so far.
*/

// O(n) time and O(n) space by forward-backward traversal
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        // DP from left to right;
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            left[i] = Math.max(left[i-1], prices[i]-min);
        }

        //DP from right to left;
        right[prices.length-1] = 0;
        int max = prices[prices.length-1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(prices[i], max);
            right[i] = Math.max(right[i+1], max-prices[i]);
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
	    profit = Math.max(left[i]+right[i], profit);
	}  
        return profit;
    }
}

// a generalization to at most K transactions
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int K = 2;
        int[][] dp = new int[K+1][prices.length];
        for (int i = 1; i < dp.length; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.max(dp[i][j-1], prices[j]+maxDiff);
                maxDiff = Math.max(maxDiff, dp[i-1][j]-prices[j]);
            }
        }
        return dp[K][prices.length-1];
    }
}
