/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

Example
    Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

Challenge
    O(n) time and O(1) memory
    O(n) time and O(n) memory is also acceptable.
*/

/*
Thought process:

*/

public class Solution {
    public int trapRainWater(int[] heights) {
        int left = 0, right = heights.length - 1, result = 0, maxleft = 0, maxright = 0;
        while (left <= right) {
            if (heights[left] <= heights[right]) {
                if (heights[left] >= maxleft) {
                    maxleft = heights[left];
                } else {
                    result += maxleft - heights[left];
		}
                left++;
            } else {
                if (heights[right] >= maxright) {
                    maxright = heights[right];
                } else { 
                    result += maxright - heights[right];
		}
                right--;
            }
        }
        return result;
    }
}
