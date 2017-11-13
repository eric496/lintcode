/*
Merge two given sorted integer array A and B into a new sorted integer array.

Example
    A=[1,2,3,4]
    B=[2,4,5,6]
    return [1,2,2,3,4,4,5,6]

Challenge
    How can you optimize your algorithm if one array is very large and the other is very small?
*/

/*
Thought process:
    This problem is just the merge part of mergesort algorithm. Create a new array whose size is size(A) + size(B). 
    Do a pair comparison between two elements from A and B at each position, put the smaller one in the new array. Meanwhile, move the position pointer forward accordingly.
*/

class Solution {
    public int[] mergeSortedArray(int[] A, int[] B) {
        int lenA = A.length, lenB = B.length;
        int[] result = new int[lenA+lenB];
        int ix = 0, ixA = 0, ixB = 0;
        while (ixA < lenA && ixB < lenB) {
            result[ix++] = (A[ixA] < B[ixB]) ? A[ixA++] : B[ixB++];
	}
        while (ixA < lenA) {
	    result[ix++] = A[ixA++]; 
	}
        while (ixB < lenB) {
	    result[ix++] = B[ixB++];
	}
        return result;
    }
}
