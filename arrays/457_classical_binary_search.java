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
    Think carefully about the edge case for while loop condition (low < high or low <= high or does not matter?) 
    Use small + (large - small) / 2 to get the middle point because it can avoid integer overflow for large integer.
*/

public class Solution {
    public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        // same if low < high
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
	    } else if (nums[mid] > target) {
                high = mid - 1;
	    } else if (nums[mid] < target) {
                low = mid + 1;
	    }
        }
        return -1;
    }
}
