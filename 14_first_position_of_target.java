/*
For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.
If the target number does not exist in the array, return -1.

Example
If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
*/

class Solution {
    public int binarySearch(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        while(low + 1 < high) {
            int middle = (high + low) / 2;
            if(target <= nums[middle]) {
                high = middle;
            } else {
                low = middle;
            }
        }
        if(nums[low] == target) return low;
        if(nums[high] == target) return high;
        return -1;
    }
}
