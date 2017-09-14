/*
Give an integer array，find the longest increasing continuous subsequence in this array.
An increasing continuous subsequence:
    Can be from right to left or from left to right.
    Indices of the integers in the subsequence should be continuous.

Notice
    O(n) time and O(1) extra space.

Example
    For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.
    For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.
*/

/*
Thought process:
    1. A straightforward approach is just loop through the array from left and right respectively.
       If latter element is greater than the previous, then counter increments by 1. Otherwise, 
       set counter to 1. At the end of each loop, compare the current count with the max count 
       and save the larger one as max count.
*/

public class Solution {
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if(A.length == 0) return 0;
        if(A.length == 1) return 1;
        int result = 0;
        int left = 1;
        int right = 1;
        for(int i = 0; i < A.length - 1; i++) {
            if(A[i] < A[i+1]) {
                left++;
            } else {
                left = 1;
            }
            result = Math.max(result, left);
        }
        
        for(int i = A.length - 1; i >= 1; i--) {
            if(A[i] < A[i-1]) {
                right++;
            } else {
                right = 1;
            }
            result = Math.max(result, right);
        }
        return result;
    }
}
