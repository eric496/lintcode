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
    1. Loop through the array, putting all positive integers in the front of the array
       by swapping two integers, so finally it should be A[0] = 1, A[1] = 2, ... A[i] = i+1
    2. Use a while loop because we might swap two positive integers, so we want both of them 
       to be in the correct order. 
    3. Notice the conditions in the while loop:
           1) A[i] > 0              ~ (positive integer)
           2) A[i] <= A.length      ~ (the positive integer should be in the range [1, n])
           3) A[i] != i + 1         ~ (the positive integer is not in the right place) 
    4. If we do not find any missing positive in array A within its length, then return 
       A.length + 1 because the missing integer must be last one in the sequence. 
       e.g. Given [1,2,0] return 3.
          
*/

public class Solution {
    public int firstMissingPositive(int[] A) {
        if (A == null) return 1;
        for(int i = 0; i < A.length; i++) {
            while(A[i] > 0 && A[i] <= A.length && A[i] != (i+1)) {
                int tmp = A[A[i]-1];
                if(tmp == A[i]) break;
                A[A[i]-1] = A[i];
                A[i] = tmp;
            }
        }

        for(int i = 0; i < A.length; i ++) {
            if (A[i] != i + 1) return i + 1;
        }
        return A.length + 1;
    }
}
