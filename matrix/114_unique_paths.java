/*
A robot is located at the top-left corner of a m x n grid.
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.
How many possible unique paths are there?

Notice
    m and n will be at most 100.

Example
    Given m = 3 and n = 3, return 6.
    Given m = 4 and n = 5, return 35.
*/

/*
Thought process:
    Similar to 111. Climb Stairs and 114. Minimum Path Sum. The total number of possible paths for the current position is
    the sum of the number of possible paths of its left position and that of its top position,
    because only left and down moves are allowed.
    Remember to handle the corner cases - first row and column as they have only one possible path, because they have no top or left elements.  
*/

public class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 1) return 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
        return dp[m - 1][n - 1];
    }
}
