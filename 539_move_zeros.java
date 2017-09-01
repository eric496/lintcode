/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Notice
    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.
*/

public class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int pos = 0;
        for(int i = 0; i < len; i++) {
            if(nums[i] != 0) nums[pos++] = nums[i];
        }
        while(pos < len) nums[pos++] = 0;
    }
}
