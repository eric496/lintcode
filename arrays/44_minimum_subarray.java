/*
Given an array of integers, find the subarray with smallest sum.
Return the sum of the subarray.

Notice
The subarray should contain one integer at least.
*/

public class Solution {
    public int minSubArray(ArrayList<Integer> nums) {
        int sum = nums.get(0);
        int min = nums.get(0);
        for(int i = 1; i < nums.size(); i++) {
            sum = Math.min(nums.get(i), sum + nums.get(i));
            min = Math.min(sum, min);
        }
        return min;
    }
}
