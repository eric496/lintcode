/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

Example
    Given encoded message 12, it could be decoded as AB (1 2) or L (12).
    The number of ways decoding 12 is 2.
*/

/*
Thought process:
    1. DP
*/

public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] memo = new int[s.length() + 1];
        memo[0] = 1;
        memo[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); i++) {
            int one = s.charAt(i - 1) - '0';
            int two = one + (s.charAt(i - 2) - '0') * 10; 
            if(one >= 1 && one <= 9) memo[i] += memo[i-1];
            if(two >= 10 && two <= 26) memo[i] += memo[i-2];
        }
        return memo[s.length()];
    }
}
