/*
Follow up for "Unique Paths":
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Notice
    m and n will be at most 100.

Example
    For example,
    There is one obstacle in the middle of a 3x3 grid as illustrated below.
    [
      [0,0,0],
      [0,1,0],
      [0,0,0]
    ]
    The total number of unique paths is 2.
*/

/*
Thought process:
    There are 4 cases for each element in the matrix:
        1) Its top and left elements are both ones (it is a dead end and it has no path).
        2) Its top element is zero, but its left element is one (it inherits the unique paths of its top element).
        3) Its left element is zero, but its top element is one (it inherits the unique paths of its left element).
        4) Its top and left elements are both zeroes (it inherits the unique paths of its top AND left elements).
    Remember to handle the first row and column because they have no top or left elements.
*/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int col = 1; col < n; col++) {
            if(obstacleGrid[0][col-1] == 1) 
                dp[0][col] = 0;
            else 
                dp[0][col] = dp[0][col-1];
        }
        for(int row = 1; row < m; row++) {
            if(obstacleGrid[row-1][0] == 1) 
                dp[row][0] = 0;
            else 
                dp[row][0] = dp[row-1][0];
        }
        for(int row = 1; row < m; row++) {
            for(int col = 1; col < n; col++) {
                if(obstacleGrid[row-1][col] == 1 && obstacleGrid[row][col-1] == 1)
                    dp[row][col] = 0;
                else if(obstacleGrid[row-1][col] == 1) 
                    dp[row][col] = dp[row][col-1];
                else if(obstacleGrid[row][col-1] == 1)
                    dp[row][col] = dp[row-1][col];
                else 
                    dp[row][col] = dp[row-1][col] +dp[row][col-1];
            }
        }
        return dp[m-1][n-1];
    }
}
