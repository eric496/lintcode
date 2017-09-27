/*
There are n coins in a line. Two players take turns to take one or two coins 
from right side until there are no more coins left. The player who take the last coin wins.
Could you please decide the first play will win or lose?

Example
    n = 1, return true.
    n = 2, return true.
    n = 3, return false.
    n = 4, return true.
    n = 5, return true.

Challenge
    O(n) time and O(1) memory
*/

/*
Thought process:
    1. O(1) time and space: in order to win, we would like leave 3 coins to the other player 
       so that no matter 1 or 2 coins he takes, we will always win. This generalizes to each 
       run actually, we'd like to leave 3x coins to the other player after each run. 
       With this said, if we are the first play, win/lose completely depends on the initial number of 
       coins, if it is not multiples of 3, we will always win by taking 1 or 2 coins to make the
       left 3x coins. Otherwise, we will always lose because the other player will take the same 
       strategy.
*/

// O(1) time and O(1) space
public class Solution {
    public boolean firstWillWin(int n) {
        return n % 3 == 0 ? false: true;
    }
}

// O(n) time and O(1) space
public class Solution {
    public boolean firstWillWin(int n) {
        if(n <= 0) return false;
        if(n <= 2) return true;
        boolean[] dp = new boolean[n+1];
        dp[0] = false; 
        dp[1] = true;
        dp[2] = true;
        for(int i = 4; i < n + 1; i++) dp[i] = dp[i-3];
        return dp[n];
    }
}
