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
        if (nums == null || nums.size() == 0) return 0;
        int n = nums.size();
        int[] leftMax = new int[n];
        int maxSofar = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            maxSofar = Math.max(maxSofar+nums.get(i), nums.get(i));
            max = Math.max(max, maxSofar);
            leftMax[i] = max;
        }
        int[] rightMax = new int[n];
        maxSofar = 0;
        max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--){
            maxSofar = Math.max(maxSofar+nums.get(i), nums.get(i));
            max = Math.max(max, maxSofar);
            rightMax[i] = max;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            result = Math.max(result, leftMax[i]+rightMax[i+1]);
        }
        return result;
    }
}
