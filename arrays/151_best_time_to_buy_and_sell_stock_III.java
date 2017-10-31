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
        A forward pass to calculate the max profit so far to the left; a backward pass to calculate the max profit so far to the right.
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
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        //DP from right to left;
        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(prices[i], max);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
	    profit = Math.max(left[i] + right[i], profit);
	}  
        return profit;
    }
}
