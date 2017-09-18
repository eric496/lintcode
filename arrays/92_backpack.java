/*
Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?

Notice
    You can not divide any item into small pieces.

Example
    If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.
    You function should return the max size we can fill in the given backpack.

Challenge
    O(n x m) time and O(m) memory.
    O(n x m) memory is also acceptable if you do not know how to optimize memory.
*/

public class Solution {
    public int backPack(int m, int[] A) {
        int row = A.length;
        int col = m + 1;
        int[][] dp = new int[row][col];
        for(int i = 0; i < row; i++) dp[i][0] = 0;
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(A[0] <= j) {
                    dp[0][j] = A[0];
                } else {
                    dp[0][j] = 0;
                }
                if(A[i] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-A[i]] + A[i], dp[i-1][j]);
                }
            }
        }
        return dp[row-1][col-1];
    }
}
