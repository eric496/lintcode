/*
Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.

Example
    For s1 = "aabcc", s2 = "dbbca"
        When s3 = "aadbbcbcac", return true.
        When s3 = "aadbbbaccc", return false.

Challenge
    O(n2) time or better
*/

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if ((s1.length()+s2.length()) != s3.length()) return false;
        boolean[][] dp = new boolean[s2.length()+1][s1.length()+1];
        dp[0][0] = true;
        for (int i = 1; i < dp[0].length; i++){
            dp[0][i] = dp[0][i-1] && (s1.charAt(i-1) == s3.charAt(i-1));
        }
        for (int i = 1; i < dp.length; i++){
            dp[i][0] = dp[i-1][0] && (s2.charAt(i-1) == s3.charAt(i-1));
        }
        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){
                dp[i][j] = (dp[i-1][j] && (s2.charAt(i-1) == s3.charAt(i+j-1)))
                        || (dp[i][j-1] && (s1.charAt(j-1) == s3.charAt(i+j-1)));
            }
        }
        return dp[s2.length()][s1.length()];
    }
}
