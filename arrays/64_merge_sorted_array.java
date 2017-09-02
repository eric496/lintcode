/*
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Notice
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.

Example
A = [1, 2, 3, empty, empty], B = [4, 5]
After merge, A will be filled as [1, 2, 3, 4, 5]
*/

class Solution {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int ix = m + n - 1;
        m--;
        n--;
        while(m >= 0 && n >= 0) {
            if(A[m] > B[n]) {
                A[ix] = A[m];
                ix--;
                m--;
            } else {
                A[ix] = B[n];
                ix--;
                n--;
            }
        }
        while(m >= 0) A[ix--] = A[m--];
        while(n >= 0) A[ix--] = B[n--];
    }
}
