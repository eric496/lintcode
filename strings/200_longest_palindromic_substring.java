/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

Example
    Given the string = "abcdzdcab", return "cdzdc".

Challenge
    O(n2) time is acceptable. Can you do it in O(n) time.
*/

// method 1
public class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int currLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i-currLength-1, i)) {
                result = s.substring(i-currLength-1, i+1);
                currLength += 2;
            } else if (isPalindrome(s, i-currLength, i)) {
                result = s.substring(i-currLength, i+1);
                currLength += 1;
            }
        }
        return result;
    }
    
    public boolean isPalindrome(String s, int start, int end){
        if (start < 0) return false;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
	}
        return true;
    }
}

// DP - O(n^2) time
public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String result = null;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i < 3 || dp[i+1][j-1]);
                if (dp[i][j] && (result == null || j-i+1 > result.length())) {
                    result = s.substring(i, j + 1);
                }
            }
        }
      return result;
    }
}
