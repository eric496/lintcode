/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.

Notice
    You may assume no duplicate exists in the array.

Example
    Given [4, 5, 6, 7, 0, 1, 2] return 0
*/

/*
Thought process:
    Binary search
*/

// O(logn) time and O(1) space
public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[high] > nums[mid]) {
                // the min is in the left part
                high = mid;
            } else if (nums[high] < nums[mid]) {
                // the min is in the right part
                low = mid + 1;
            }
        }
        return nums[low];
    }
}
