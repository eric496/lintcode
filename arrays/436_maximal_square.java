/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

Example
    For example, given the following matrix:
    1 0 1 0 0
    1 0 1 1 1
    1 1 1 1 1
    1 0 0 1 0
    Return 4.
*/

// DP - O(n^2) time
public class Solution {
    public int maxSquare(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length, col = matrix[0].length, edge = 0;
        int[][] dp = new int[row+1][col+1];
        for (int i = 1 ; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if(matrix[i-1][j-1] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j-1]), dp[i-1][j]) + 1;
                    edge = Math.max(dp[i][j], edge); // update result
                }
            }
        }
        return edge * edge;
    }
}
