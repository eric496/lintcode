/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Notice
    You may not slant the container.

Example
    Given [1,3,2], the max area of the container is 2.
*/

/*
Thought process:
    Two pointers:
        Iterate the array from both ends, update the max area, and then move the pointer whose height is lower.  
        Notice that if heights[left] == heights[right], we should move both pointers, because moving any single pointer unilaterally will reduce the area.
*/

public class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int maxSofar = 0 ;
        while (left <= right) {
            int area = (right - left) * Math.min(heights[left], heights[right]);
            maxSofar = Math.max(maxSofar, area);
            if (heights[left] < heights[right]) {
                left++;
            } else if (heights[left] > heights[right]) {
                right--;
            } else {
                left++; 
                right--;
            }
        }
        return maxSofar;
    }
}
