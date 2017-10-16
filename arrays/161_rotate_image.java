/*
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).

Example
    Given a matrix
    [
        [1,2],
        [3,4]
    ]
    rotate it by 90 degrees (clockwise), return
    [
        [3,1],
        [4,2]
    ]

Challenge
    Do it in-place.
*/

public class Solution {
    public void rotate(int[][] matrix) {
        int s = 0, e = matrix.length - 1;
        while(s < e){
            int[] temp = matrix[s];
            matrix[s] = matrix[e];
            matrix[e] = temp;
            s++; e--;
        }
    
        for(int i = 0; i < matrix.length; i++){
            for(int j = i+1; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
