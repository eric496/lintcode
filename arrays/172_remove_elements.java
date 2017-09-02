/*
Given an array and a value, remove all occurrences of that value in place and return the new length.
The order of elements can be changed, and the elements after the new length don't matter.

Example
Given an array [0,4,4,0,0,2,4,4], value=4
return 4 and front four elements of the array is [0,0,0,2]
*/

/*
Thought process
1. IN PLACE: probably use two pointers.
2. Intuitively, we would like judge if value = k. But it is not straightforward programmatically this way. 
   Instead we will judge if value != k, and keep moving these values in the front of the array.
*/

public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A == null || A.length == 0) return 0;
        int i = 0;
        int j = 0;
        while(i < A.length) {
            if(A[i] != elem) A[j++] = A[i];
            i++;
        }
        return j;
    }
}
