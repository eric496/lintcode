/*
Given a string s, cut s into some substrings such that every substring is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.

Example
    Given s = "aab",
    Return 1 since the palindrome partitioning ["aa", "b"] could be produced using 1 cut.
*/

public class Solution {
    public int minCut(String s) {
        if(s.length() == 0) return 0;
        int[] c = new int[s.length()+1];
        for(int i = 0; i < s.length(); i++) 
            c[i]=Integer.MAX_VALUE;
        c[s.length()] = -1;
        for(int i=s.length()-1;i>=0;i--){
            for(int a = i, b = i; a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b); a--,b++) 
                c[a] = Math.min(c[a], 1+c[b+1]);
            for(int a = i, b = i + 1 ; a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b); a--, b++) 
                c[a]=Math.min(c[a],1+c[b+1]);
        }
        return c[0];
    }
}

// DP
public class Solution {
    public int minCut(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        boolean[][] p = new boolean[len+1][len+1];
        for (int i = 1; i <= len; i++) {
            dp[i] = i;
            for (int j = 1; j <= i; j++) {
                if (s.charAt(i-1) == s.charAt(j-1)) {
                    if (i - j < 2 || p[j+1][i-1]) {
                        p[j][i] = true;
                        if (j == 1) 
                            dp[i] = 0;
                        else {
                            dp[i] = Math.min(dp[i], dp[j-1]+1);
                        }
                    }
                }
            }
        }
        return dp[len];
    }
}
