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
    This problem is just the merge part of mergesort algorithm.
    Create a new array whose size is size(A) + size(B). Do a pair comparison of each two elements from A and B, 
    put the smaller one in the new array. Meanwhile, move the position pointer forward accordingly.
*/

class Solution {
    public int[] mergeSortedArray(int[] A, int[] B) {
        int lenA = A.length, lenB = B.length;
        int[] result = new int[lenA+lenB];
        int pos = 0, posA = 0, posB = 0;
        while(posA < lenA && posB < lenB)
            result[pos++] = (A[posA] < B[posB]) ? A[posA++] : B[posB++];
        while(posA < lenA) result[pos++] = A[posA++];
        while(posB < lenB) result[pos++] = B[posB++];
        return result;
    }
}
