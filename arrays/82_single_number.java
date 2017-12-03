/*
Given 2*n + 1 numbers, every numbers occurs twice except one, find it.

Example
    Given [1,2,2,1,3,4,3], return 4

Challenge
    One-pass, constant extra space.
*/

/*
Thought process:
    1. Sort the array first, then check each element at odd index equals its previous element. If not, its previous element is the single number.
       Return the last element in the array if single number is not found in the iteration.  
    2. A ^ A is 0, and XOR operation follows communicative law, e.g. A ^ B ^ A = A ^ A ^ B = B.
       e.g. [1,2,1,2,5] 
            1^2^1^2^5 = 1^1^2^2^5 = 0^0^5 = 5.
*/

// O(n) time and O(1) space by sorting
public class Solution {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) return 0;
        Arrays.sort(A);
        int pos = 1;
        while (pos < A.length) {
            if (A[pos] != A[pos-1]) return A[pos-1];
            pos += 2;
        }
        return A[A.length-1];
    }
}

// O(n) time and O(1) space by bit manipulation
public class Solution {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) return 0;
	int result = A[0];
        for (int i = 1; i < A.length; i++) {
	    result ^= A[i];
	}
        return result;
    }
}
