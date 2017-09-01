/*
Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.
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

public class Solution {
    public int numIslands(boolean[][] grid) {
        if(grid.length == 0 || grid[0].length == 0 || grid == null) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!grid[i][j]) continue;
                dfs(grid, i, j);
                result++;
            }
        }
        return result;
    }
    
    private void dfs(boolean[][] grid, int i, int j) {
        if(i < 0 || i >=grid.length || j < 0 || j >= grid[0].length) return;
        if(grid[i][j]) {
            grid[i][j] = false;
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
}
