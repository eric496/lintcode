/*
Given a string S and a string T, count the number of distinct subsequences of T in S.
A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example
    Given S = "rabbbit", T = "rabbit", return 3.

Challenge
    Do it in O(n2) time and O(n) memory.
    O(n2) memory is also acceptable if you do not know how to optimize memory.
*/

/*
Thought process:
    DP: Use characters in S as columns and characters in T as rows:
             |  ""  |  "r"  |  "a"  |  "b"  |  "b"  |  "b"  |  "i"  |  "t"  |
        ""   |   1  |   1   |   1   |   1   |   1   |   1   |   1   |   1   | 
        "r"  |   0  |   1   |   1   |   1   |   1   |   1   |   1   |   1   |
        "a"  |   0  |   0   |   1   |   1   |   1   |   1   |   1   |   1   | 
        "b"  |   0  |   0   |   0   |   1   |   2   |   3   |   3   |   3   |
        "b"  |   0  |   0   |   0   |   0   |   1   |   3   |   3   |   3   |
        "i"  |   0  |   0   |   0   |   0   |   0   |   0   |   3   |   3   |
        "t"  |   0  |   0   |   0   |   0   |   0   |   0   |   0   |   3   |
    
	The first row and column are empty strings. An empty string is 1 distinct subsequence of the empty string, so dp[0][0] = 1. 
        An empty string is 1 distinct subsequence of any other non-empty strings, so dp[0][i] = 1, for all elements in the first row.
        Any non-empty string is not a distinct subsequence of the empty string, so dp[i][0] = 0, for all elements in the first column execpt the first element.
        For any dp[i][j] where i >= 1 and j >= 1 in the table, there are 2 cases:
            1) if T[i-1] != S[j-1], then dp[i][j] equals the number of distinct subsequences without the new character (dp[i][j-1]).
	    2) if T[i-1] == S[j-1], then dp[i][j] equals case 1) plus the number of subsequences one character shorter (dp[i-1][j-1]).
*/

// O(n^2) time and O(n^2) space
public class Solution {
    public int numDistinct(String S, String T) {
        if (S == null || T == null) return 0;
        int[][] nums = new int[T.length()+1][S.length()+1];
        for (int i = 0; i <= S.length(); i++) {
            nums[0][i] = 1;
        }
        for (int i = 1; i <= T.length(); i++) {
            for (int j = 1; j <= S.length(); j++) {
                if (T.charAt(i-1) == S.charAt(j-1)) {
                    nums[i][j] = nums[i-1][j-1] + nums[i][j-1];
                } else {
                    nums[i][j] = nums[i][j-1];
                }
            }
        }
        return nums[T.length()][S.length()];
    }
}

// O(n^2) time and O(n) space
public class Solution {
    public int numDistinct(String S, String T) {
        if (S == null || T == null || S.length() < T.length()) return 0;
        int[] dp = new int[T.length()+1];
        dp[0] = 1;
        for (int j = 1; j <= S.length(); j++) {
            for (int i = T.length(); i >= 1; i--) {  
                dp[i] = dp[i] + (T.charAt(i-1) == S.charAt(j-1) ? dp[i-1] : 0);
            }
        }
        return dp[T.length()];
    }
}
