/*
We are playing the Guess Game. The game is as follows:
I pick a number from 1 to n. You have to guess which number I picked.
Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

Example
    Given n = 10, I pick 8.
    First round: You guess 5, I tell you that it's higher. You pay $5.
    Second round: You guess 7, I tell you that it's higher. You pay $7.
    Third round: You guess 9, I tell you that it's lower. You pay $9.
    Game over. 8 is the number I picked.
    You end up paying $5 + $7 + $9 = $21.
    Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
    So when n = ｀10, return16`
*/

public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];
        for (int l = 1; l < n; l++)
            for (int i = 1; i <= n - l; i++) {
                int j = i + l;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++)
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k + 1][j]));
            }
        return dp[1][n];
    }
}
