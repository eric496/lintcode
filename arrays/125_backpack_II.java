/*
Given n items with size Ai and value Vi, and a backpack with size m. What's the maximum value can you put into the backpack?

Notice
    You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.

Example
    Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.

Challenge
    O(n x m) memory is acceptable, can you do it in O(m) memory?
*/

/*
Thought process:
    1. DP using 2-D array: (top-down manner)
           Similar to 92. Backpack. The only difference is to use table to store values instead of weights. 
    2. DP using 1-D array: (bottom-up manner)
*/

// O(m*n) time and O(m*n) space
public class Solution {
    public int backPackII(int m, int[] A, int[] V) {
        int[][] dp = new int[A.length][m+1];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0) {
                    if (A[0] > j) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = V[0];
                    }
                } else {
                    if (A[i] > j) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-A[i]] + V[i]);
                    }
                }
            }
        }
        return dp[A.length-1][m];
    }
}

// O(m*n) time and O(m) space
public class Solution {
    public int backPackII(int m, int[] A, int[] V) {
        int[] dp = new int[m+1];
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j > 0; j--) {
                if (j >= A[i]) dp[j] = Math.max(dp[j], dp[j-A[i]] + V[i]);
            }
        }
        return dp[m];
    }
} 
