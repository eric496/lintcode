/*
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

Notice
    You may assume that each input would have exactly one solution.

Example
    Given nums = [2, 7, 11, 15], target = 9
    return [1, 2]
*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indice = new int[2];
        if (nums == null || nums.length < 2) return indice;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int v = nums[left] + nums[right];
            if (v == target) {
                indice[0] = left + 1;
                indice[1] = right + 1;
                break;
            } else if (v > target) {
                right --;
            } else {
                left ++;
            }
        }
        return indice;
    }
}
