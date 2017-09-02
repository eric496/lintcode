/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Example
Given s = "lintcode", return 0.
Given s = "lovelintcode", return 2.
*/

public class Solution {
    public int firstUniqChar(String s) {
        // size of ASCII character set is 256
        int[] ch = new int[256];
        for(int i = 0; i < s.length(); i++) ch[s.charAt(i)]++;
        for(int i = 0; i < s.length(); i++) if(ch[s.charAt(i)] == 1) return i;
        return -1;
        }
}

