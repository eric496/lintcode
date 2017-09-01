/*
Merge two given sorted integer array A and B into a new sorted integer array.

Example
A=[1,2,3,4]
B=[2,4,5,6]
return [1,2,2,3,4,4,5,6]
*/

class Solution {
    public int[] mergeSortedArray(int[] A, int[] B) {
        int len = A.length + B.length;
        int[] res = new int[len];
        int i = 0, j = 0;
        int index = 0;
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                res[index++]  = A[i++];
            }
            else {
                res[index++] = B[j++];
            }
        }
        while (i < A.length) res[index++] = A[i++];
        while (j < B.length) res[index++] = B[j++];
        return res;
    }
}
