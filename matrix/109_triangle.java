/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

Notice
    Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

Example
    Given the following triangle:
    [
         [2],
        [3,4],
       [6,5,7],
      [4,1,8,3]
    ]
    The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
*/

/*
Thought process:
    1. O(n) time and O(1) space: Bottom-up method, from the second to the last row,
       add the current element value with the smaller value from its two children,
       store it at the current position. Keep moving upward until top and return 
       triangle[0][0] which stores the min path sum. Notice this method saves space
       at the expense of changing the values of the triangle.
  
*/

// O(n) time and O(1) space
public class Solution {
    public int minimumTotal(int[][] triangle) {
        if(triangle == null || triangle.length == 0) return 0;
        if(triangle[0] == null || triangle[0].length == 0) return 0;
        if(triangle.length == 1) return triangle[0][0];
        for(int layer = triangle.length - 2; layer >= 0; layer--) {
            for(int i = 0; i < triangle[layer].length; i++) {
                triangle[layer][i] += Math.min(triangle[layer+1][i], triangle[layer+1][i+1]);
            }
        }
        return triangle[0][0];
    }
} 

// O(n) time and O(n^2) space
public class Solution {
    public int minimumTotal(int[][] triangle) {
        if(triangle == null || triangle.length == 0) return 0;
        if(triangle[0] == null || triangle[0].length == 0) return 0;
        if(triangle.length == 1) return triangle[0][0];
        int[][] result = new int[triangle.length][triangle[triangle.length-1].length];
        result[triangle.length-1] = triangle[triangle.length-1];
        for(int layer = triangle.length - 2; layer >= 0; layer--) {
            for(int i = 0; i < triangle[layer].length; i++) {
                result[layer][i] += Math.min(result[layer+1][i], result[layer+1][i+1]) + triangle[layer][i];
            }
        }
        return result[0][0];
    }
}

// O(n) time and O(n) space
public class Solution {
    public int minimumTotal(int[][] triangle) {
        if(triangle == null || triangle.length == 0) return 0;
        if(triangle[0] == null || triangle[0].length == 0) return 0;
        if(triangle.length == 1) return triangle[0][0];
        int[] result = new int[triangle.length + 1];
        for(int layer = triangle.length-1; layer >= 0; layer--) {
            for(int i = 0; i < triangle[layer].length; i++) {
                result[i] = Math.min(result[i], result[i+1]) + triangle[layer][i];
            }
        }
        return result[0];
    }
}
