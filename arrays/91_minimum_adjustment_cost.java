/*
Given an integer array, adjust each integers so that the difference of every adjacent integers are not greater than a given number target.
If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|

Notice
    You can assume each number in the array is a positive integer and not greater than 100.

Example
    Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal.
    Return 2.
*/

// DP
public class Solution {
    public int MinAdjustmentCost(List<Integer> A, int target) {
        int n = A.size();
        int[][] dp = new int[n + 1][101];
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <=100; ++j)
                dp[i][j] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= 100; ++i)
            dp[0][i] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int  j = 0; j <= 100;++j) {
                if(dp[i-1][j] != Integer.MAX_VALUE) {
                    for (int k = 0; k <= 100; ++k) {
                        if (Math.abs(j-k) <= target)
                        if (dp[i][k] > dp[i-1][j] + Math.abs(A.get(i-1)-k))
                            dp[i][k] = dp[i-1][j] + Math.abs(A.get(i-1)-k);
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= 100; ++i) {
            if (dp[n][i] < result) result = dp[n][i];
        }
        return result; 
    }
}
