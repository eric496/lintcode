/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
Trapping Rain Water

Example
    Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

Challenge
    O(n) time and O(1) memory
    O(n) time and O(n) memory is also acceptable.
*/

public class Solution {
    public int trapRainWater(int[] heights) {
        int n = heights.length;
        int left = 0; int right = n - 1;
        int res = 0;
        int maxleft = 0, maxright = 0;
        while(left <= right){
            if(heights[left] <= heights[right]){
                if(heights[left] >= maxleft) 
                    maxleft = heights[left];
                else 
                    res += maxleft-heights[left];
                left++;
            }
            else{
                if(heights[right] >= maxright) 
                    maxright = heights[right];
                else 
                    res += maxright-heights[right];
                right--;
            }
        }
        return res;
    }
}
