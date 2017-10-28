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
    1. Two pointers: Sort the array, create a variable to store the closest sum so far.
    2. Iterate the array, for any fixed index i, iterate all elements to its right using two pointers (from head and from end).
       Update closest sum if the current 3sum is closer to the target than the previous closest sum is. 
       Otherwise, increment the head pointer if current 3sum is smaller than the target, or decrease the tail pointer if current 3sum is greater than the target.  
*/

// O(n^2) time and O(1) space using two pointers
public class Solution {
    public int threeSumClosest(int[] numbers, int target) {
        if (numbers == null || numbers.length < 3) return Integer.MIN_VALUE;
        Arrays.sort(numbers);
        int closestSum = numbers[0] + numbers[1] + numbers[2];
        for (int i = 0; i < numbers.length; i++) {
            int low = i + 1, high = numbers.length - 1;
            while (low < high) {
                int curSum = numbers[i] + numbers[low] + numbers[high];
                if (Math.abs(curSum - target) < Math.abs(closestSum - target)) {
                    closestSum = curSum;
                }
                if (curSum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return closestSum;
    }
}
