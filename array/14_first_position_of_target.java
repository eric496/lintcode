/*
For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.
If the target number does not exist in the array, return -1.

Example
If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
*/

/*
Thought process
1. A classical binary search problem when you see O(log n)
2. Use start + 1 < end in while condition
3. Notice it is required to find the FIRST index, so instead of "return mid" we should instead let "end = mid" and check the value at the end
*/

class Solution {
    public int binarySearch(int[] nums, int target) {
        if(nums.length == 0 || nums == null) return -1;
        int start = 0, end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(target < nums[mid]) {
                end = mid;
            } else if(target > nums[mid]) {
                start = mid;
            } else if(target == nums[mid]) {
                end = mid;
            }
        }
        if(target == nums[start]) return start;
        if(target == nums[end]) return end;
        return -1;
    }
}
