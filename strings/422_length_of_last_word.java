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
    1. Use trim method to remove right padding and then iterate the string from backward. Return length once a space is met.
    2. Use trim and split method to return the length of the last word in the string array.
    3. Two passes: First pass moves the position pointer to the first non-space character.
                   Second pass moves on until the first space is met, during which the length counter keeps updating.
*/

// use string trim method
public class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0; 
        String strim = s.trim();
        int len = 0;
        for(int i = strim.length() - 1; i >= 0; i--) {
            if(strim.charAt(i) != ' ')
                len++;
            else
                break;
        }
        return len;
    }
}

// use string trim and split methods
public class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0; 
        String strim = s.trim();
        String[] sarray = strim.split(" ");
        return sarray[sarray.length-1].length();
    }
}

//  
public class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0; 
        int tail = s.length() - 1, len = 0;
        while(tail >= 0 && s.charAt(tail) == ' ') tail--;
        while(tail >= 0 && s.charAt(tail) != ' ') {
            tail--;
            len++;
        }
        return len;
    }
}
