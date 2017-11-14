/*
Write an efficient algorithm that searches for a value in an m x n matrix.
This matrix has the following properties:
    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

Example
    Consider the following matrix:
    [
        [1, 3, 5, 7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
    ]
    Given target = 3, return true.

Challenge
    O(log(n) + log(m)) time
*/

/*
Thought process:
    1. Linear search
    2. 2-D binary search. Binary search the row index first, and then the column index.
*/

// O(m+n) time
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        if (matrix[0] == null || matrix[0].length == 0) return false;
        int numRows = matrix.length, numCols = matrix[0].length, targetRow = 0, targetCol = numCols - 1;
        while (targetRow < numRows && targetCol >= 0) {
            if (matrix[targetRow][targetCol] == target) {
                return true;
            } else if (matrix[targetRow][targetCol] < target) {
                targetRow++;
            } else {
                targetCol--;
            }
        }
        return false;
    }
}

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
	if (matrix == null || matrix.length == 0) return false;
        if (matrix[0] == null || matrix[0].length == 0) return false;
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        // find the row index, the last number <= target 
        int start = 0, end = numRow - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
	int targetRow = -1;
        if (matrix[end][0] <= target) {
            targetRow = end;
        } else if (matrix[start][0] <= target) {
            targetRow = start;
        } else {
            return false;
        }
        
        // find the column index, the number equal to target
        start = 0;
        end = column - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[targetRow][mid] == target) {
                return true;
            } else if (matrix[targetRow][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[targetRow][start] == target) {
            return true;
        } else if (matrix[targetRow][end] == target) {
            return true;
        }
        return false;
    }
}
