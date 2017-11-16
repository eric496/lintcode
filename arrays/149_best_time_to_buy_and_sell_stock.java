/*
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example
    Given array [3,2,3,1,2], return 1.
*/

/*
Thought process:
    1. The basic idea is to maintain two variables to store minimum so far and maximum so far.
       Iterate the array, if the current element is smaller than min so far, then update min so far with the current element.
       Otherwise, compare the current element minus min so far with max so far, with whichever is greater update max so far.
    2. Kadane's algorithm: Refer to 41. Maximum Subarray
*/

// min so far and max so far
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minSofar = prices[0], maxSofar = Integer.MIN_VALUE;
        for (int price : prices) {
            if (price < minSofar) {
                minSofar = price;
            } else if (price - minSofar > maxSofar) {
                maxSofar = price - minSofar;
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
