/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Notice
    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.
*/

/*
Thought process:
    Two pointers: One pointer points at the current insert position for non-zero values. 
                  The other pointer iterates the array, find the next non-zero element, and insert at the position where the first pointer points to.
                  Fill in zeroes for all left positions after the iteration. 
*/

//O(n) time and O(1) space
public class Solution {
    public void moveZeroes(int[] nums) {
        int ix = 0;
        for (int n : nums) {
            if (n != 0) {
                nums[ix++] = i;
            }
        }
        while (ix < nums.length) {
            nums[ix++] = 0;
        }
    }
}
