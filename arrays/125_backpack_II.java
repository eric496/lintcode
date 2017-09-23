/*
Given n items with size Ai and value Vi, and a backpack with size m. What's the maximum value can you put into the backpack?

Notice
    You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.

Example
    Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.

Challenge
    O(n x m) memory is acceptable, can you do it in O(m) memory?
*/

/*
Thought process:
    1. Similar to 92. backpack. The only difference is to add value instead of weight. 
*/

public class Solution {
    public int backPackII(int m, int[] A, int V[]) {  
        int[][] dp = new int[A.length][m+1];
        for(int i = 0; i < m + 1; i++) {
            if(A[0] > i) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = V[0];
            }
        }
        
        for (int i = 1; i < A.length; i++) {  
            for (int j = 1; j < m + 1; j++) {  
                if (A[i] <= j) {  
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-A[i]] + V[i]);  
                } else {  
                    dp[i][j] = dp[i-1][j];  
                }  
            }  
        }  
        return dp[A.length-1][m];  
    }  
}
