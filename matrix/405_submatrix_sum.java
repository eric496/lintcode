/*
Given an integer matrix, find a submatrix where the sum of numbers is zero. Your code should return the coordinate of the left-up and right-down number.

Example
    Given matrix
    [
      [1 ,5 ,7],
      [3 ,7 ,-8],
      [4 ,-8 ,9],
    ]
    return [(1,1), (2,2)]

Challenge
    O(n3) time.
*/

public class Solution {
    public int[][] submatrixSum(int[][] matrix) {
        int[][] result = new int[2][2];
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 0 || col == 0) return result;
        int[][] sum = new int[row+1][col+1];
        for (int j = 0; j <= col; j++) sum[0][j] = 0;
        for (int i = 1; i <= row; i++) sum[i][0] = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum[i+1][j+1] = matrix[i][j] + sum[i+1][j] + sum[i][j+1] - sum[i][j];
            }
        }
        for (int l = 0; l < row; l++) {
            for (int h = l + 1; h <= row; h++) {
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                for (int j = 0; j <= col; j++) {
                    int diff = sum[h][j] - sum[l][j];
                    if (map.containsKey(diff)) {
                        int k = map.get(diff);
                        result[0][0] = l;   
                        result[0][1] = k;
                        result[1][0] = h - 1; 
                        result[1][1] = j - 1;
                        return result;
                    } else {
                        map.put(diff, j);
                    }
                }
            }
        }
        return result;
    }
}
