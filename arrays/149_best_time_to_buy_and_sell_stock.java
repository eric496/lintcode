/*
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example
    Given array [3,2,3,1,2], return 1.
*/

/*
Thought process:
    1. The basic idea is to iteratively search for minimum price so far, and maximum so far: Create a so far min and a global max variables.  
       Iterate the array, if the current price is greater than min so far, then update the global max with (current - min so far) if it is greater than the current global max.
       Otherwise if the current price is smaller than min so far, update min so far with the current price.
    2. Kadane's algorithm: Refer to 41. Maximum Subarray
*/

// min so far and max so far
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minSofar = prices[0], maxSofar = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minSofar) {
                minSofar = prices[i];
            } else {
                maxSofar = Math.max(prices[i] - minSofar, maxSofar);
            }
        }
        return maxSofar;
    }
}

// Kadane's algorithm
public class Solution {
    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur += prices[i] - prices[i-1];
            maxCur = Math.max(0, maxCur);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
