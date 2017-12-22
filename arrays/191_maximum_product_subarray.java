/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example
    For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
*/

/*
Thought process:

*/

// method 1
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

// method 2 (improvement)
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int maxSofar = nums[0], minSofar = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                maxSofar = Math.max(maxSofar*nums[i], nums[i]);
                minSofar = Math.min(minSofar*nums[i], nums[i]);
            } else {
                int temp = maxSofar;
                maxSofar = Math.max(minSofar*nums[i], nums[i]);
                minSofar = Math.min(temp*nums[i], nums[i]);
            }
            result = Math.max(result, maxSofar);
        }
        return result;
    }
}
