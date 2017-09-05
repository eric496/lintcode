/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
If the last word does not exist, return 0.

Notice
A word is defined as a character sequence consists of non-space characters only.

Example
Given s = "Hello World", return 5.
*/

/*
Thought process:
    1. Use trim method to remove right padding and then loop through the string backward. 
       Return length once a space is found.
    2. Append an extra space to the string. Check both current element and the element to right are spaces.
       If so, continue, if not return the length.
*/

// use string trim method
public class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0; 
        String strim = s.trim();
        int len = 0;
        for(int i = strim.length() - 1; i >= 0; i--) {
            if(strim.charAt(i) != ' ') {
                len++;
            } else {
                break;
            }
        }
        return len;
    }
}

// append an extra space at the end of the string
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
