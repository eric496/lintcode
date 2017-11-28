/*
Given an array with integers.
Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.
Return the largest difference.

Notice
    The subarray should contain at least one number

Example
    For [1, 2, -3, 1], return 6.

Challenge 
    O(n) time and O(n) space.
*/

public class Solution {
    public int maxDiffSubArrays(int[] nums) {
        int size = nums.length;
        int[] leftMax = new int[size];
        int[] leftMin = new int[size];
        int[] rightMax = new int[size];
        int[] rightMin = new int[size];
        int[] copy = new int[size];
        /*Get negative copy*/
        for (int i = 0; i < size; i++) {
            copy[i] = -1 * nums[i];
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;
        /*Forward: get max subarray*/
        for (int i = 0; i < size; i++) {
            sum += nums[i];
            max = Math.max(max, sum-minSum);
            minSum = Math.min(sum, minSum);
            leftMax[i] = max;
        }
        /*Backward: get max subarray*/
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for (int i = size - 1; i >= 0; i--) {
            sum += nums[i];
            max = Math.max(max, sum-minSum);
            minSum = Math.min(sum, minSum);
            rightMax[i] = max;
        }
        /*Forward: get min subarray*/
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for (int i = 0; i < size; i++) {
            sum += copy[i];
            max = Math.max(max, sum-minSum);
            minSum = Math.min(sum, minSum);
            leftMin[i] = -1 * max;
        }
        /*Backward: get min subarray*/
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for (int i = size - 1; i >= 0; i--) {
            sum += copy[i];
            max = Math.max(max, sum-minSum);
            minSum = Math.min(sum, minSum);
            rightMin[i] = -1 * max;
        }
        int diff = 0;
        for (int i = 0; i < size - 1; i++) {
            diff = Math.max(diff, Math.abs(leftMax[i]-rightMin[i+1]));
            diff = Math.max(diff, Math.abs(leftMin[i]-rightMax[i+1]));
        }
        return diff;
    }
}
