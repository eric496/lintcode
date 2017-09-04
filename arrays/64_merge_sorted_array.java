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
    1. In-place solution: It is hard to compare elements and store them in A in forward order. 
       So think about the comparison from the end. Do a pair comparison of each two elements from A and B from the end, 
       store the larger one at the end of A. 
    2. NOTICE that if there are more elements in B than A, we need to put the extra elements from B in their corresponding 
       locations in A. On the other hand, we don't have to worry the extra elements in A if A has more elements than B, 
       because they are already in the correct locations.
*/

class Solution {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int ix = m + n - 1;
        m--;
        n--;
        while(m >= 0 && n >= 0) A[ix--] = (A[m] > B[n]) ? A[m--] : B[n--];
        while(n >= 0) A[ix--] = B[n--];
    }
}
