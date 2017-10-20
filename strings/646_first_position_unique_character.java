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
       to find the first non-repeating character, if its count equals one. 
    2. If the problem applies to unicode, we should use hash map instead.
*/

// O(n) time and O(1) space - with fixed size array
public class Solution {
    public int firstUniqChar(String s) {
	if(s == null || s.length() == 0) return -1;
        int[] count = new int[256];
        for(int i = 0; i < s.length(); i++) count[s.charAt(i)]++;
        for(int i = 0; i < s.length(); i++) 
	    if(count[s.charAt(i)] == 1) return i;
        return -1;
    }
}


// method 2
public class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;
        int[] count = new int[256];
        for(char c : s.toCharArray()) count[c] += 1;
        for(char c : s.toCharArray())
            if(count[c] == 1) return s.indexOf(c);
        return -1;
    }
}

// Hashmap
public class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {
            if(map.containsKey(c)) 
                map.put(c, map.get(c)+1);
            else
                map.put(c, 1);
        }
        for(char c : s.toCharArray())
            if(map.get(c) == 1) return s.indexOf(c);
        return -1;
    }
}
