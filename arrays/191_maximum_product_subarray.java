/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example
    For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
*/

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int maxPrev = nums[0], minPrev = nums[0], max = nums[0], maxSofar, minSofar;
        for (int i = 1; i < nums.length; i++) {
            maxSofar = Math.max(Math.max(maxPrev*nums[i], minPrev*nums[i]), nums[i]);
            minSofar = Math.min(Math.min(maxPrev*nums[i], minPrev*nums[i]), nums[i]);
            max = Math.max(maxSofar, max);
            maxPrev = maxSofar;
            minPrev = minSofar;
        }
        return max;
    }
}
