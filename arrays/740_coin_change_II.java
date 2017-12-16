/*
You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

Notice
    You can assume below:
        0 <= amount <= 5000
        1 <= coin <= 5000
        the number of coins is less than 500
        the answer is guaranteed to fit into signed 32-bit integer

Example
    Given amount = 10, coins = [10], return 1
    Given amount = 8, coins = [2, 3, 8], return 3
    there are three ways to make up the amount:
    8 = 8
    8 = 3 + 3 + 2
    8 = 2 + 2 + 2 + 2
*/

/*
Thought process:
    DP
*/

public class Solution {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0 || amount <= 0) return 0;
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }
}
