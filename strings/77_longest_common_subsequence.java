/*
Given two strings, find the longest common subsequence (LCS).
Your code should return the length of LCS.

Clarification
    What's the definition of Longest Common Subsequence?
        https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
        http://baike.baidu.com/view/2020307.htm

Example
    For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.
    For "ABCD" and "EACB", the LCS is "AC", return 2.
*/

/*
Thought process:
    DP: Create a table with rows representing one string and coloumns the other.
              ""  |  "A"  |  "B"  |  "C"  |  "D"  |
       ""  |  0   |   0   |   0   |   0   |   0   |
       "E" |  0   |   0   |   0   |   0   |   0   |
       "A" |  0   |   1   |   1   |   1   |   1   |
       "C" |  0   |   1   |   1   |   2   |   2   |
       "B" |  0   |   1   |   2   |   2   |   2   |
        If two characters are the same, then dp[i][j] is dp[i-1][j-1] + 1. If two characters are different, then dp[i][j] equals either dp[i-1][j] or dp[i][j-1] whichever is greater.
*/

public class Solution {
    public int longestCommonSubsequence(String A, String B) {
        int n = A.length(), m = B.length();
        int dp[][] = new int[n+1][m+1];
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
