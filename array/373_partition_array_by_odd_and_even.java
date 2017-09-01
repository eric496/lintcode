/*
Partition an integers array into odd number first and even number second.

Example
Given [1, 2, 3, 4], return [1, 3, 2, 4]
*/

public class Solution {
    public void partitionArray(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            while(nums[start] % 2 == 1) start++;
            while(nums[end] % 2 == 0) end--;
            if(start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;    
                start++;
                end--;
            }
        }
    }
}
