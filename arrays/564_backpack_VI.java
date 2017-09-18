/*
Given an integer array nums with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Notice
    A number in the array can be used multiple times in the combination.
    Different orders are counted as different combinations.

Example
    Given nums = [1, 2, 4], target = 4
    The possible combination ways are:
    [1, 1, 1, 1]
    [1, 1, 2]
    [1, 2, 1]
    [2, 1, 1]
    [2, 2]
    [4]
    return 6
*/

public class Solution {
    public int backPackVI(int[] nums, int target) {
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 1; i <= target; ++i)
            for (int  j = 0; j < nums.length; ++j)
                if (i >= nums[j]) f[i] += f[i - nums[j]];
        return f[target];
    }
}
