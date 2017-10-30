/*
Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?

Notice
    You can not divide any item into small pieces.

Example
    If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.
    Your function should return the max size we can fill in the given backpack.

Challenge
    O(n x m) time and O(m) memory.
    O(n x m) memory is also acceptable if you do not know how to optimize memory.
*/

/*
Thought process:
    1. DP using 2D array:
    2. DP using 1D array:
*/

// O(m*n) time and O(m*n) memory
public class Solution {
    public int backPack(int m, int[] A) {
        int[][] dp = new int[A.length][m+1];
        for (int i = 0; i < A.length; i++) {
            // start from the second column because the first column is always zeros
            for (int j = 1; j < m + 1; j++) {
                // initialize the first row
                if (i == 0) {
                    if (A[0] <= j) dp[0][j] = A[0];
                } else {
                    if (A[i] > j) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-A[i]] + A[i]);
                    }       
                }
            }
        }
        return dp[A.length-1][m];
    }
}

// O(m*n) time and O(m) memory
public class Solution {
    public int backPack(int m, int[] A) {
        int[] dp = new int[m+1];
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j > 0; j--) {
                if (j >= A[i]) dp[j] = Math.max(dp[j], dp[j-A[i]] + A[i]);
            }
        }
        return dp[m];
    }
}
