/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Notice
    You can only move either down or right at any point in time.
*/

/*
Thought process:
    1. Create a 2-D array to keep track of the current min sum.
    2. Compare sum of current grid item and its min sum from left
       with sum of the current grid item and its min sum from up.
       Keep the min sum as the current min sum. 
    3. Remember to handle the first row and the first column
       as they have only one option to sum (for the first row, 
       it can only sum its left items, for the first column, it 
       can only sum its up items.) 
*/

public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid == null || m == 0 || n == 0) return -1;
        int[][] sum = new int[m][n];
        sum[0][0] = grid[0][0];
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(row == 0 && col != 0) {
                    sum[row][col] = sum[row][col-1] + grid[row][col];
                } else if(col == 0 && row != 0) {
                    sum[row][col] = sum[row-1][col] + grid[row][col];
                } else if(row != 0 && col != 0) {
                    sum[row][col] = Math.min(sum[row-1][col], sum[row][col-1]) + grid[row][col];
                }
            }
        }
        return sum[m-1][n-1];
    }
}
