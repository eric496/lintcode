/*
Follow up for Search in Rotated Sorted Array:
What if duplicates are allowed?
Would this affect the run-time complexity? How and why?
Write a function to determine if a given target is in the array.

Example
    Given [1, 1, 0, 1, 1, 1] and target = 0, return true.
    Given [1, 1, 1, 1, 1, 1] and target = 0, return false.
*/

public class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (target == nums[mid]) {
                return true;
            } else if (nums[l] <= nums[mid]) {
                if(nums[l] == nums[mid]) 
                    ++l;
                else if(target >= nums[l] && target < nums[mid])
                    r = mid - 1;
                else 
                    l = mid + 1;
            } else if(nums[mid] <= nums[r]) {
                if(nums[mid] == nums[r]) 
                    --r;
                else if(target > nums[mid] && target <= nums[r]) 
                    l = mid + 1;
                else 
                    r = mid - 1;
            }
        }
        return false;
    }
}
