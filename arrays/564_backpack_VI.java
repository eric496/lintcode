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

/*
Thought process:
    1. Recursive solution: 
           Base case: return 1 when target == 0, since there is only one way to add up to 0.
           Recursive step: Image we only need one more number to obtain the target, that number could be any number in the array.
                           So combi(target) = sum(combi(target - nums[i])) for 0 <= i < nums.length given that target >= nums[i].
    2. DP: (top-down manner)
    3. DP: (bottom-up manner)
*/

// recursive, but it will cause TLE
public class Solution {
    public int backPackVI(int[] nums, int target) {
        if (target == 0) return 1;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                result += backPackVI(nums, target - nums[i]);
            }
        }
        return result;
    }
}

// DP: top-down
public class Solution {
    private int[] dp;
    public int backPackVI(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return dfs(nums, target);
    }
    
    private int dfs(int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += dfs(nums, target - nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }
}

// DP: bottom-up
public class Solution {
    public int backPackVI(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; ++i) {
            for (int j = 0; j < nums.length; ++j) {
                if (i >= nums[j]) dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }
}
