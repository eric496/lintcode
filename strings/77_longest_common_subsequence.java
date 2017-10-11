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
    DP
*/

public class Solution {
    public int longestCommonSubsequence(String A, String B) {
        int n = A.length();
	    int m = B.length();
        int f[][] = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if(A.charAt(i - 1) == B.charAt(j - 1)) f[i][j] = f[i - 1][j - 1] + 1;
            }
        }
        return f[n][m];
    }
}
