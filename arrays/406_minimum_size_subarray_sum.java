/*
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return -1 instead.

Example
    Given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.

Challenge
    If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
*/

// O(n) time by two pointers
public class Solution {
    public int minimumSize(int[] nums, int s) {
        if (nums == null || nums.length == 0) return -1;
        int sum = 0, start = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                min = Math.min(min, i-start+1);
                sum -= nums[start++];
            }
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }
}

// O(nlogn) time
