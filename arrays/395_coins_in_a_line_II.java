/*
There are n coins with different value in a line. 
Two players take turns to take one or two coins from left side until there are no more coins left. 
The player who take the coins with the most value wins.
Could you please decide the first player will win or lose?

Example
    Given values array A = [1,2,2], return true.
    Given A = [1,2,4], return false.
*/

/*
Thought process:
    State: dp[i] records the max value one can get from ith coin to the end
    Function: when we are at ith coin, we have 2 choices:
        1) values[i]
           The other player has 2 choices too: 
             a. values[i+1]
             b. values[i+1] + values[i+2]
           Given that the other player is rational and wants to make you gain least value for the rest of the game, 
           so best1 = values[i] + min(dp[i+2], dp[i+3]) 
        2) values[i] + values[i+1]
           The other player has 2 choices too:
             a. values[i+2]
             b. values[i+2] + values[i+3]
           Given that the other player is rational and wants to make you gain least value for the rest of the game, 
           so best2 = values[i] + values[i+1] + min(dp[i+3], dp[i+4])
     Finally, dp[i] = max(best1, best2)
*/

public class Solution {
    public boolean firstWillWin(int[] values) {
        int len = values.length;
        if (values.length <= 2) return true;
        int[] dp = new int[len+1];
        // why do we need to calculate dp from the end of the value?
        // because the choice of taking 1 or 2 coins is determined by later game (choices after the current pick), so it is easier to traverse from backward
        dp[len] = 0;
        // if one coin left, take it anyways
        dp[len-1] = values[len-1];
        // if two coins left, take them all anyways
        dp[len-2] = values[len-1] + values[len-2];
        // if three coins left, take two anyways
        dp[len-3] = values[len-3] + values[len-2];
        // if there are four coins left, you have strategies. you can take one and the other player will take two and you will take the last one
        // or you can take two and the other player will take the rest
        // game theory: you always maximize your result while your competitor always minimizes your result
        for (int i = len - 4; i >= 0; i--) {
            int value1 = values[i] + Math.min(dp[i+2], dp[i+3]);
            int value2 = values[i] + values[i+1] + Math.min(dp[i+3], dp[i+4]);
            dp[i] = Math.max(value1, value2);
        }
        int sum = 0;
        for (int v : values) {
	    sum += v;
	}
        return dp[0] > sum - dp[0];
    }
}
