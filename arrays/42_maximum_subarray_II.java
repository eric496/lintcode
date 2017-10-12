/*
Given an array of integers, find two non-overlapping subarrays which have the largest sum.
The number in each subarray should be contiguous.
Return the largest sum.

Notice
    The subarray should contain at least one number

Example
    For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, 2] or [1, 3, -1, 2] and [2], they both have the largest sum 7.

Challenge
    Can you do it in time complexity O(n) ?
*/

public class Solution {
    public int maxTwoSubArrays(List<Integer> nums) {
        if(nums == null || nums.size() == 0) return 0;
        int n = nums.size();
        int [] left = new int[n];
        int local = 0;
        int global = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            local = Math.max(local + nums.get(i), nums.get(i));
            global = Math.max(global, local);
            left[i] = global;
        }
        int [] right = new int[n];
        local = 0;
        global = Integer.MIN_VALUE;
        for(int i = n-1; i>=0; i--){
            local = Math.max(local + nums.get(i), nums.get(i));
            global = Math.max(global, local);
            right[i] = global;
        }
        int result = Integer.MIN_VALUE;
        for(int i = 0; i<n-1; i++)
            result = Math.max(result, left[i] + right[i+1]);
        return result;
    }
}
