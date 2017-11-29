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
    3. Iterate the string from backward, find the position of the first non-space character.
       Then find the position of the first space. The length in between is the result.
       
*/

// use string trim method
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0; 
        String strim = s.trim();
        int len = 0;
        for (int i = strim.length() - 1; i >= 0; i--) {
            if (strim.charAt(i) != ' ') {
                len++;
            } else {
                break;
	    }
        }
        return len;
    }
}

// use string trim and split methods
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0; 
        String strim = s.trim();
        String[] sarray = strim.split(" ");
        return sarray[sarray.length-1].length();
    }
}

// 
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0; 
        int tail = s.length() - 1, len = 0;
        while (tail >= 0 && s.charAt(tail) == ' ') {
	    tail--;
	}
        while (tail >= 0 && s.charAt(tail) != ' ') {
            tail--;
            len++;
        }
        return len;
    }
}

// one pass
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.trim().length() == 0) return 0;
        // a flag variable - whether the counting begins
        boolean startCount = false;
        int count = 0;
        // traverse from backward
        for (int i = s.length() - 1; i >= 0; i--) {
            // skip all trailing spaces
            if (s.charAt(i) == ' ' && !startCount) {
                continue;
            // the first character found, increment counter and change flag variable state
            } else if (s.charAt(i) != ' ' && !startCount) {
                count++;
                startCount = !startCount;
            // keep counting continuous characters
            } else if (s.charAt(i) != ' ' && startCount) {
                count++;
            // the first space found, which means the last word ends
            } else if (s.charAt(i) == ' ' && s.charAt(i+1) != ' ') {
                break;
            }
        }
        return count;
    }
}
