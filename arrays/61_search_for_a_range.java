/*
Given a sorted array of n integers, find the starting and ending position of a given target value.
If the target is not found in the array, return [-1, -1].

Example
    Given [5, 7, 7, 8, 8, 10] and target value 8,
    return [3, 4].

Challenge
    O(log n) time.
*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int hi = nums.length - 1;
        int low = 0;
        int[] rs = new int[2];
       // base case
        if(nums == null || nums.length == 0)
        	return new int[]{-1, -1 };
       //left side
        while(low < hi){
        	int mid = low + (hi - low) /2;
        	if(target > nums[mid])
        		low = mid + 1;
        	else
        		hi = mid;
        }
        if(target == nums[low])
    		rs[0] = low;
        else
        	rs[0] = -1;
        //right side
        hi = nums.length - 1;
        while(low < hi){
        	int mid = (low + (hi - low) /2 ) + 1;
        	if(target < nums[mid])
        		hi = mid - 1;
        	else
        		low = mid;
        }   
        if(target == nums[hi])
    		rs[1] = hi;
        else
        	rs[1] = -1;
        return rs;
    }
}
