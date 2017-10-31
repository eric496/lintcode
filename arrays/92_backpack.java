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
    1. DP using 2D array: (top-down manner)
           Say if we have 4 items with size [2, 3, 5, 7], the backpack size is 11. We can use a table to calculate the result.
           
           item size \ backpack size  |  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |  10  |  11  |
                     2                |  0  |  0  |  2  |  2  |  2  |  2  |  2  |  2  |  2  |  2  |   2  |   2  |
                     3                |  0  |  0  |  2  |  3  |  3  |  5  |  5  |  5  |  5  |  5  |   5  |   5  |
                     5                |  0  |  0  |  2  |  3  |  3  |  5  |  5  |  7  |  8  |  8  |  10  |  10  | 
                     7                |  0  |  0  |  2  |  3  |  3  |  5  |  5  |  7  |  8  |  9  |  10  |  10  |

           The columns of the table represent sizes of backpack, the rows of the table represent item sizes. Each cell of the table represents
           the max size we can fill using the items of its own row and those above it, given a certain backpack size specified by the column. 
           The decision is binary: we can either include the current item or not. We would like to calculate max size we can fill constraint by current backpack size.
           So for each cell, it can either inherit the max size from the same column but a row above it (this is not including the current item) or 
           The current item size plus the corresponding max size of the current backpack size subtracts the current item size (this is including the current item), 
           whichever is greater, in order to obtain the max size so far.
           
    2. DP using 1D array: (bottom-up manner)
           
*/

// O(m*n) time and O(m*n) memory
public class Solution {
    public int backPack(int m, int[] A) {
        int[][] dp = new int[A.length][m+1];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < m + 1; j++) {
                // initialize the first row
                if (i == 0) {
                    if (A[0] > j) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = A[0];
                    }
                } else {
                    // if current item size is greater than the current backpack size, inherit the max size from the previous row
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
