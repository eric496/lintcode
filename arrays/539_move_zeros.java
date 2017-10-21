/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Notice
    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.
*/

/*
Thought process:
    Two pointers: One position pointer starting at 0 and incrementing by 1, 
    the other pointer iterates the array, find the next non-zero element, and fill the position where the first pointer is at.
    Fill all left positions with zeroes after the iteration. 
*/

//O(n) time and O(1) space by two pointers
public class Solution {
    public void moveZeroes(int[] nums) {
        int pos = 0;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] != 0) nums[pos++] = nums[i];
        while(pos < nums.length) nums[pos++] = 0;
    }
}
