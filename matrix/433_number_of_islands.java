/*
Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. 
If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.
Find the number of islands.

Example
    Given graph:
    [
      [1, 1, 0, 0, 0],
      [0, 1, 0, 0, 1],
      [0, 0, 0, 1, 1],
      [0, 0, 0, 0, 0],
      [0, 0, 0, 0, 1]
    ]
    return 3.
*/

/*
Thought process:
    Iterate rows and columns, at each element recursively check its neighbors. Remember to flip true element to false.
*/

public class Solution {
    public int numIslands(boolean[][] grid) {
        if (grid.length == 0 || grid[0].length == 0 || grid == null || grid[0] == null) return 0;
        int numRows = grid.length;
        int numCols = grid[0].length;
        int result = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (!grid[i][j]) continue;
                dfs(grid, i, j);
                result++;
            }
        }
        return result;
    }
    
    private void dfs(boolean[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;
        if (grid[row][col]) {
            grid[row][col] = false;
            dfs(grid, row-1, col);
            dfs(grid, row+1, col);
            dfs(grid, row, col-1);
            dfs(grid, row, col+1);
        }
    }
}
