/*
Given an array of integers, find the subarray with smallest sum.
Return the sum of the subarray.

Notice
The subarray should contain one integer at least.
*/

/*
Thought process: the same to 41, using Kadane's algorithm
*/

public class Solution {
    public int minSubArray(ArrayList<Integer> nums) {
        int localMin = nums.get(0), globalMin = nums.get(0);
        for(int i = 1; i < nums.size(); i++) {
            localMin = Math.min(localMin + nums.get(i), nums.get(i));
            if(localMin < globalMin) globalMin = localMin;
        }
        return globalMin;
    }
}
