/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Example
Given s = "lintcode", return 0.
Given s = "lovelintcode", return 2.
*/

/*
Thought process:
    1. If all characters are in ASCII set, we can do two passes: first one to populate
       the array with count of appearance for each character in the string. Second loop 
       to find the first non-repeating character, if its count == 1. 
    2. If the problem applies to unicode, we should use hash map instead.
*/

// O(n) time and O(1) space - with fixed size array
public class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[256];
        for(int i = 0; i < s.length(); i++) count[s.charAt(i)]++;
        for(int i = 0; i < s.length(); i++) if(count[s.charAt(i)] == 1) return i;
        return -1;
    }
}

