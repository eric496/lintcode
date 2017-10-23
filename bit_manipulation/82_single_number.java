/*
Given 2*n + 1 numbers, every numbers occurs twice except one, find it.

Example
    Given [1,2,2,1,3,4,3], return 4

Challenge
    One-pass, constant extra space.
*/

/*
Thought process:
    1. A ^ A is 0, and XOR operation follows communicative law, e.g. A ^ B ^ A = A ^ A ^ B = B.
       e.g. [1,2,1,2,5] 
            1^2^1^2^5 = 1^1^2^2^5 = 0^0^5 = 5.
*/


// one-pass, O(n) time and O(1) space
public class Solution {
    public int singleNumber(int[] A) {
        if(A == null || A.length == 0) return 0;
        for(int i = 1; i < A.length; i++) 
	    A[0] ^= A[i];
        return A[0];
    }
}
