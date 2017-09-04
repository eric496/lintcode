/*
Given 2*n + 1 numbers, every numbers occurs twice except one, find it.

Example
Given [1,2,2,1,3,4,3], return 4

Challenge: One-pass, constant extra space.
*/

public class Solution {
    public int singleNumber(int[] A) {
        if(A == null || A.length == 0) return 0;
        for(int i = 1; i < A.length; i++) A[0] ^= A[i];
        return A[0];
    }
}
