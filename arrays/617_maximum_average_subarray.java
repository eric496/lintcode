/*
Given an array with positive and negative numbers, find the maximum average subarray which length should be greater or equal to given length k.

Notice
    It's guaranteed that the size of the array is greater or equal to k.

Example
    Given nums = [1, 12, -5, -6, 50, 3], k = 3
    Return 15.667 // (-6 + 50 + 3) / 3 = 15.667
*/

public class Solution {
    public double maxAverage(int[] nums, int k) {
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        for (int n: nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        double lastMid = max, error = Integer.MAX_VALUE;
        while (max - min > 0.00001) {
            double mid = (max + min) / 2.0;
            if (check(nums, mid, k)) {
                min = mid;
            } else {
                max = mid;
            }
            error = Math.abs(lastMid-mid);
            lastMid = mid;
        }
        return min;
    }

    private boolean check(int[] nums, double mid, int k) {
        double sum = 0, prev = 0, minSum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i] - mid;
        }
        if (sum >= 0) return true;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - mid;
            prev += nums[i-k] - mid;
            minSum = Math.min(prev, minSum);
            if (sum >= minSum) return true;
        }
        return false;
    }
}
