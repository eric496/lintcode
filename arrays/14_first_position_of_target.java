/*
For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.
If the target number does not exist in the array, return -1.

Example
    If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
*/

/*
Thought process
    It is similar to classical binary search with some tiny variations. We should be careful about that the return of "first" index of the target number. 
    So after the while loop, it is possible the low-end and high-end runners can be both the target number. We need to check the low-end first, and then the high-end.
*/

class Solution {
    public int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
	// no equal sign because it is possible to have duplicates and we would like the first unique
        while (low < high) {
            int mid = low + (high - low) / 2;
            // if mid point is target, do not return immediately because it might not be the first target
            if (nums[mid] == target) {
                // set high to mid, because the first target could only occurs before mid rather than behind it`
                high = mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else { 
                low = mid + 1;
            }
        }
        if (nums[low] == target) return low;
        if (nums[high] == target) return high;
        return -1;
    }
}
