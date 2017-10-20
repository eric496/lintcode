/*
For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.
If the target number does not exist in the array, return -1.

Example
    If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
*/

/*
Thought process
    It is nothing more than a classical binary search. The only thing that should be careful about is return the "first" index of the target number. 
    So after the while loop, it is possible the low-end and high-end runners can be both the target number. We need to check the low-end first, 
    and then the high-end in order to return the "first" index of the target number.
*/

class Solution {
    public int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target)
                high = mid;
            else if(nums[mid] > target)
                high = mid - 1;
            else 
                low = mid + 1;
        }
        if(nums[low] == target) return low;
        if(nums[high] == target) return high;
        return -1;
    }
}
