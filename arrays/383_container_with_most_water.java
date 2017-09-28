/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Notice
    You may not slant the container.

Example
    Given [1,3,2], the max area of the container is 2.
*/

/*
Thought process:
    1. Refer to: https://leetcode.com/problems/container-with-most-water/discuss/
*/

public class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int maxArea = 0;
        while(left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(heights[left], heights[right]));
            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
