/*
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example
    Given array [3,2,3,1,2], return 1.


*/

/*
Thought process:
   1. Create a min so far and a global max variables. 
      If current price is greater than min so far, then compare update global max with the larger value of global max and current price minus min so far.
      Otherwise, update min so far with current price.
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int sofarMin = prices[0], max = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] > sofarMin) {
                max = Math.max(max, prices[i] - sofarMin);
            } else {
                sofarMin = prices[i];
            }
        }
        return max;
    }
}
