/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
If the last word does not exist, return 0.

Notice
A word is defined as a character sequence consists of non-space characters only.

Example
Given s = "Hello World", return 5.
*/

public class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0; 
        int len = 0;
        int count = 0;
        s = s + ' ';
        char[] c = s.toCharArray();
        for(int i = c.length - 2; i >= 0; i--) {
            if(c[i] == ' ') {
                if(c[i+1] == ' ') {
                    continue;
                } else {
                    break;
                }
            } else {
                len++;
            }
        }
        return len;
    }
}
