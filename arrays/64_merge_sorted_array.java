/*
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Notice
    You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.

Example
    A = [1, 2, 3, empty, empty], B = [4, 5]
    After merge, A will be filled as [1, 2, 3, 4, 5]
*/

/*
Thought process:
    In-place solution: It is hard to compare elements and store them in A in forward order. But since A has enough space at the end,
    we can compare elements from backward. 
    Do a pair comparison of each two elements from the end, store the larger one at the end of A, whose position pointer should 
    accordingly move one step. 
    !! If there are more elements in B than A, we need to append the extra elements from B to A. 
    On the other hand, we don't have to worry the extra elements in A if A has more elements than B, because they are already in position.
*/

class Solution {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int ixa = m - 1, ixb = n - 1, ix = m + n - 1;
        while(ixa >= 0 && ixb >= 0) 
            A[ix--] = A[ixa] > B[ixb] ? A[ixa--] : B[ixb--];
        while(ixb >= 0) 
            A[ix--] = B[ixb--];
    }
}
