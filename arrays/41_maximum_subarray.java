/*
Given an array of integers, find a contiguous subarray which has the largest sum.

Notice
The subarray should contain at least one number.

Example
Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
*/

/*
Thought process
1. Kadane's algorithm: 
   the maximum sum of a contiguous subarray ending at a specific element is either 
   1) the maximum sum of a contiguous subarray ending at its previous element, OR
   2) the specific element itself, 
   depending on which is larger. 
   So, the algorithm is bascially loop through the array, compare each element with max sum of subarray ending at its previous element, 
   keep the larger one and update the global maximum.
*/

//Kadane's algorithm
public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int localMax = nums[0], globalMax = nums[0];
        for(int i = 1; i < nums.length; i++) {
            localMax = Math.max(localMax + nums[i], nums[i]);
            if(localMax > globalMax) globalMax = localMax;
        }
        return globalMax;
    }
}
