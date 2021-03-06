/*
Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.
This matrix has the following properties:
    Integers in each row are sorted from left to right.
    Integers in each column are sorted from up to bottom.
    No duplicate integers in each row or column.

Example
    Consider the following matrix:
    [
       [1, 3, 5, 7],
       [2, 4, 7, 8],
       [3, 5, 9, 10]
    ]
    Given target = 3, return 2.

Challenge
    O(m+n) time and O(1) extra space
*/

public class Solution {
    public int searchMatrix(int[][] matrix, int target) {
        int r = matrix.length - 1;
        int c = 0;
        int ans = 0;
        while (r >= 0 && c < matrix[0].length) {
            if (target == matrix[r][c]) {
                ans++;
                r--;
                c++;
                continue;
            }
            if (target < matrix[r][c]) {
                r--;
            } else {
                c++;
            }
        }
        return ans;
    }
}
