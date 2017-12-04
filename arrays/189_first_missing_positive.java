/*
Given an unsorted integer array, find the first missing positive integer.

Example
    Given [1,2,0] return 3,
    and [3,4,-1,1] return 2.

Challenge
    Your algorithm should run in O(n) time and uses constant space.
*/

/*
Thought process:
    Sort the positive integers by swapping two integers, so for any positive integer, its value is 1 greater than its index, i.e. A[0] = 1, A[1] = 2, ... A[i] = i+1.
    Notice the conditions in the while loop:
        1) A[i] > 0              ~ (positive integer)
        2) A[i] <= A.length      ~ (the positive integer should be in the range [1, n])  e.g. [1,2,4,-2,10]
        3) A[i] != i + 1         ~ (the positive integer is not in the correct position) 
    If we do not find any missing positive integer in the sequence, the last integer must be the missing one, because that is the only one we have not checked yet.
    e.g. Given [0,1,2] return 3.
          
*/

public class Solution {
    public int firstMissingPositive(int[] A) {
        if (A == null) return 1;
        for (int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] <= A.length && A[i] != i + 1) {
                if (A[A[i]-1] == A[i]) break;
                int tmp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = tmp;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) return i + 1;
        }
	// corner case: the last number is the missing one
        return A.length + 1;
    }
}
