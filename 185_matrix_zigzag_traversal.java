/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in ZigZag-order.

Example
Given a matrix:
[
  [1, 2,  3,  4],
  [5, 6,  7,  8],
  [9,10, 11, 12]
]
return [1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12]
*/

public class Solution {
    public int[] printZMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix == null) return null;
        int n = matrix[0].length;
        int m = matrix.length;
        int[] result = new int[m * n];
        int row = 0;
        int col = 0;
        int ix = 1;
        result[0] = matrix[0][0]; 
        while(ix < result.length) {
            //move right or down by 1
            if(row + 1 < m || col + 1 < n) {
                if(col + 1 < n) {
                    result[ix++] = matrix[row][++col];
                } else if(row + 1 < m) {
                    result[ix++] = matrix[++row][col];
                }
            }

            //move down-left
            while(col - 1 >= 0 && row + 1 < m) result[ix++] = matrix[++row][--col];

            //move down or right by 1
            if(row + 1 < m || col + 1 < n) {
                if(row + 1 < m) {
                    result[ix++] = matrix[++row][col];
                } else if(col + 1 < n) {
                    result[ix++] = matrix[row][++col];
                }
            }
            
            //move up-right
            while(row - 1 >= 0 && col + 1 < n) result[ix++] = matrix[--row][++col];
        }
        return result;
    }
}
