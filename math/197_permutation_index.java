/*
Given a permutation which contains no repeated number, find its index in all the permutations of these numbers, which are ordered in lexicographical order. The index begins at 1.

Example
    Given [1,2,4], return 1.
*/

/*
Thought process
    Count the number of the succeeding numbers of the current number which are smaller than the current number (each one from left to right), 
    set it to smaller_succeed. Suppose the index of the current number is i, we exchange the current number with one smaller succeeding number.
    After the exchange, if the length from the current number (exclusive) to the end of the array is n, then there are n! eligible permutations.
    Multiply smaller_succeed * n!, we get the possible permutations for the current number. Add the statistic up for every number, 
    we get the total number of permutations ahead of the current permutation (initialize index = 1 will assure to return the current index).
*/

public class Solution {
    public long permutationIndex(int[] A) {
        if (A == null || A.length == 0) return 0;
        long index = 1;
        for (int i = 0; i < A.length; i++) {
            int rank = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
		    rank++;
		}
	    }
            index += rank * factorial(A.length-i-1);
        }
        return index;
    }
    
    private long factorial(long n) {
        if(n == 0) return 1;
        if(n <= 2) return n;
        return n * factorial(n-1);
    }
}
