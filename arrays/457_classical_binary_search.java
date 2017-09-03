/*
Find any position of a target number in a sorted array. Return -1 if target does not exist.

Example
Given [1, 2, 2, 4, 5, 5].
For target = 2, return 1 or 2.
For target = 5, return 4 or 5.
For target = 6, return -1.
*/

/*
Thought process: 
    Remember to check the values at "start" and "end", 
    because the while loop ends at where "start" meets "end", 
    while the values at "start" and "end" haven't been checked yet.
*/

public class Solution {
    public int findPosition(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(target == nums[mid]) {
                return mid;
            } else if(target > nums[mid]) {
                start = mid + 1;
            } else if(target < nums[mid]) {
                end = mid - 1;
            }
        }
        if(target == nums[start]) return start;
        if(target == nums[end]) return end;
        return -1;
    }
}
