/*
Given two array of integers(the first array is array A, the second array is array B), now we are going to find a element in array A which is A[i], and another element in array B which is B[j], so that the difference between A[i] and B[j] (|A[i] - B[j]|) is as small as possible, return their smallest difference.

Example
    For example, given array A = [3,6,7,4], B = [2,8,9,3], return 0

Challenge
    O(n log n) time
*/

public class Solution {
    public int smallestDifference(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) return 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0, j = 0;
        int minDiff = Integer.MAX_VALUE;
        while (i < A.length && j < B.length) {
            minDiff = Math.min(Math.abs(A[i] - B[j]), minDiff);
            if (A[i] < B[j])
                i++;
            else
                j++;
        }
        return minDiff;
    }
}
