/*
Find the kth smallest number in at row and column sorted matrix.

Example
    Given k = 4 and a matrix:
    [
      [1 ,5 ,7],
      [3 ,7 ,8],
      [4 ,8 ,9],
    ]
return 5

Challenge
    Solve it in O(klogn) time where n is the bigger one between row size and column size.
*/

/*
Thought process:
    Binary search
*/

// binary search 
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
	int low = matrix[0][0], high = matrix[matrix.length-1][matrix[0].length-1] + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0,  j = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
		    j--;
		}
                count += j + 1;
            }
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
	    }
        }
        return low;
    }
}
