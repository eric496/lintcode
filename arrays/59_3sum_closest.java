/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.

Notice
    You may assume that each input would have exactly one solution.

Example
    For example, given array S = [-1 2 1 -4], and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Challenge
    O(n^2) time, O(1) extra space
*/

/*
Thought process:
    1. Sort the array first and then initialize a optimal sum variable. 
    2. Loop through the whole sorted array, for each num[i], the temporary sum is 
       num[i] plus the low end nums[low] and the high end nums[high]. 
       Compare (target - sum) with (target - bestSum) and update bestSum.
       If temporary sum is smaller than the target, move forward the low end. Otherwise, 
       move backward the high end.   
*/

public class Solution {
    public int threeSumClosest(int[] numbers, int target) {
        if (numbers == null || numbers.length < 3) return -1;
        Arrays.sort(numbers);
        int bestSum = numbers[0] + numbers[1] + numbers[2];
        for (int i = 0; i < numbers.length; i++) {
            int low = i + 1, high = numbers.length - 1;
            while (low < high) {
                int sum = numbers[i] + numbers[low] + numbers[high];
                if (Math.abs(target - sum) < Math.abs(target - bestSum)) bestSum = sum;
                if (sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return bestSum;
    }
}
