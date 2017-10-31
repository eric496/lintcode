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
           The competitor have 2 choices too: 
             a. values[i+1]
             b. values[i+1] + values[i+2]
           Given that the competitor is reasonable who wants to make you gain least value for the rest of the game, 
           so best1 = values[i] + min(dp[i+2], dp[i+3]) 
        2) values[i] + values[i+1]
           The competitor have 2 choices too:
             a. values[i+2]
             b. values[i+2] + values[i+3]
           Given that the competitor is reasonable who wants to make you gain least value for the rest of the game, 
           so best2 = values[i] + values[i+1] + min(dp[i+3], dp[i+4])
     Finally, dp[i] = max(best1, best2)
*/

public class Solution {
    public boolean firstWillWin(int[] values) {
        int len = values.length;
        if (values.length <= 2) return true;
        int[] dp = new int[len+1];
        dp[len] = 0;
        dp[len-1] = values[len-1];
        dp[len-2] = values[len-1] + values[len-2];
        dp[len-3] = values[len-3] + values[len-2];
        for (int i = len-4; i >= 0; i--) {
            int value1 = values[i] + Math.min(dp[i+2], dp[i+3]);
            int value2 = values[i] + values[i+1] + Math.min(dp[i+3], dp[i+4]);
            dp[i] = Math.max(value1, value2);
        }
        int sum = 0;
        for (int v : values) sum += v;
        return dp[0] > sum - dp[0];
    }
}
