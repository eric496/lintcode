/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
You have the following 3 operations permitted on a word:
    Insert a character
    Delete a character
    Replace a character

Example
    Given word1 = "mart" and word2 = "karma", return 3.
*/

/*
Thought process:
    DP: For exmple word1 = "azced", and word2 = "abcdef" 
         ""    "a"    "b"    "c"    "d"    "e"    "f"
    ""   0      1      2      3      4      5      6
    "a"  1      0      2      3      4      5      6
    "z"  2      1      1      2      3      4      5
    "c"  3      2      2      1      2      3      4
    "e"  4      3      3      2      3      2      3
    "d"  5      4      4      3      2      3      3

    Using the characters in word2 as the first row, the characters in word1 as the first column. 
    Add an extra row and column which represent empty strings. The row represent partial string. 
    For example, row 2 and column 5 (which is 4) represents converting from "abcd" to "a".
    There are two cases: 
        1) the current character is different from the converted (insert, delete, replace are all possible operations)
           draw a square of 4 elements using the current cell as the bottom right one. Use the minimum of the other 3 element, 
           plus 1 as the result for the current cell value.
        2) the current character is the same as the converted (nothing needs to be done)
           draw the same square and use the diagonal element as the current cell value.
*/

// O(n^2) time and O(n^2) space
public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 0; i < len2 + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < len1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[len1][len2];
    }
}

// O(n^2) time and O(n) space
