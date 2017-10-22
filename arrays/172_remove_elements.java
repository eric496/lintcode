/*
Given an array and a value, remove all occurrences of that value in place and return the new length.
The order of elements can be changed, and the elements after the new length don't matter.

Example
    Given an array [0,4,4,0,0,2,4,4], value=4
    return 4 and front four elements of the array is [0,0,0,2]
*/

/*
Thought process:
    Two pointers: A counter as well as a position pointer points to the last position so far for a non-target value.
                  Iterate the array, if the current element is not the target value, copy it to the counter position.
*/

// two pointers
public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A == null || A.length == 0) return 0;
        int count = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] != elem) A[count++] = A[i];
        }
        return count;
    }
}
