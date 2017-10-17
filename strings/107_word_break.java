/*
Given a string s and a dictionary of words dict, determine if s can be break into a space-separated sequence of one or more dictionary words.

Example
    Given s = "lintcode", dict = ["lint", "code"].
    Return true because "lintcode" can be break as "lint code".
*/

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] f = new boolean[s.length()+1];
        f[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}
