/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example
    There exist two distinct solutions to the 4-queens puzzle:
    [
      // Solution 1
      [".Q..",
       "...Q",
       "Q...",
       "..Q."
      ],
      // Solution 2
      ["..Q.",
       "Q...",
       "...Q",
       ".Q.."
      ]
    ]

Challenge
    Can you do it without recursion?
*/

// recursive 
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        String[] queens = new String[n];
        char[] initial = new char[n];
        Arrays.fill(initial, '.');
        Arrays.fill(queens, String.valueOf(Arrays.copyOf(initial, n)));
        int[] flag = new int[5*n-2];
        Arrays.fill(flag, 1);
        solve(result, queens, flag, 0, n);
        return result;
    }
    
    private void solve(List<List<String>> result, String[] queens, int[] flag, int row, int n){
        if (row == n) {
            result.add(new ArrayList<String>(Arrays.asList(queens)));
            return;
        }
        for (int col = 0; col != n; col++) {
            if (flag[col] == 1 && flag[n+col+row] == 1 && flag[4*n-2+col-row] == 1) {
                flag[col] = 0;
                flag[n+col+row] = 0;
                flag[4*n-2+col-row] = 0;
                char[] chars = queens[row].toCharArray();
                chars[col] = 'Q';
                queens[row] = String.valueOf(chars);
                solve(result, queens, flag, row+1, n);
                chars = queens[row].toCharArray();
                chars[col] = '.';
                queens[row] = String.valueOf(chars);
                flag[col] = 1;
                flag[n+col+row] = 1;
                flag[4*n-2+col-row] = 1;
            }
        }
    }
}
