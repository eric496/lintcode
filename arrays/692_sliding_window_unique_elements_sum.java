/*
Given an array and a window size that is sliding along the array, find the sum of the count of unique elements in each window.

Example
    Given a array nums = [1, 2, 1, 3, 3] and k = 3
    First window [1, 2, 1], only 2 is unique, count is 1.
    Second window [2, 1, 3], all elements unique, count is 3.
    Third window [1, 3, 3], only 1 is unique, count is 1.
    sum of count = 1 + 3 + 1 = 5
    Return 5
*/

public class Solution {
    private int result = 0;
    public int slidingWindowUniqueElementsSum(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) return -1;
        if (k > nums.length) {
            k = nums.length;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        countUnique(map);
        for (int i = k; i < nums.length; i++) {
            map.put(nums[i-k], map.get(nums[i-k])-1);
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
            countUnique(map);
        }
        return result;
    }
    
    private void countUnique(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) {
                result++;
            }
        }
    }
}
