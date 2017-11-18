/*
Given an array of integers, replace every element with the next greatest element (greatest element on the right side) in the array. Since there is no element next to the last element, replace it with -1. For example, if the array is [16, 17, 4, 3, 5, 2], then it should be modified to [17, 5, 5, 5, 2, -1].

Example
    Give nums = [16, 17, 4, 3, 5, 2], change nums to [17, 5, 5, 5, 2, -1]
    You should do it in place.
*/

/*
Thought process:
    Initialize max so far with the last element. Iterate the array, make a copy of the current element and update it with max so far. 
    Update max so far with comparison to the copy of the current element. Finally make the last element -1. 
*/

public class Solution {
    public void arrayReplaceWithGreatestFromRight(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int maxSofar = nums[nums.length-1];
        for (int i = nums.length - 2; i >= 0; i--) {
            int cur = nums[i];
            nums[i] = maxSofar;
            maxSofar = cur > maxSofar ? cur : maxSofar;
        }
        nums[nums.length-1] = -1;
    }
}
