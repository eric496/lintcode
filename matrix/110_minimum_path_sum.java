/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Notice
    You can only move either down or right at any point in time.
*/

/*
Thought process:
    DP: Create a 2D array to store the minimum sum so far at each position.
        Since we can move either right or down, the basic idea to calculate minimum sum so far is by adding the current element 
        to minimum sum so far at its left position or its top position, whichever is smaller.
        Remember to handle the first row and the first column separately as they have only one direction to move forward 
        (right for the first row and down for the first column). This is a simplified case, because we do not need to make comparison,
        instead we just add the current element to the previous sum. 
*/

// O(mn) time and O(mn) space by DP
public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid[0] == null || grid.length == 0 || grid[0].length == 0) return -1;
        int numRows = grid.length, numCols = grid[0].length;
        int[][] dp = new int[numRows][numCols];
        dp[0][0] = grid[0][0];
        for(int rowix = 0; rowix < numRows; rowix++) {
            for(int colix = 0; colix < numCols; colix++) {
                if(rowix == 0 && colix != 0)
                    dp[rowix][colix] = dp[rowix][colix-1] + grid[rowix][colix];
                else if(colix == 0 && rowix != 0)
                    dp[rowix][colix] = dp[rowix-1][colix] + grid[rowix][colix];
                else if(rowix != 0 && colix != 0)
                    dp[rowix][colix] = Math.min(dp[rowix-1][colix], dp[rowix][colix-1]) + grid[rowix][colix];
            }
        }
        return dp[numRows-1][numCols-1];
    }
}
