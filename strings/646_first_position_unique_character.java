/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Example
    Given s = "lintcode", return 0.
    Given s = "lovelintcode", return 2.
*/

/*
Thought process:
    1. Use an array of size 256 if given ASCII. 
       We can complete it with two passes: first pass stores the character frequency. 
       Second pass looks for the first non-repeating character, where the frequency is 1. 
    2. Use hash map if given a much larger or complicated encoding standard.
*/

// O(n) time and O(1) space using array
public class Solution {
    public int firstUniqChar(String s) {
	if (s == null || s.length() == 0) return -1;
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
	    count[s.charAt(i)]++;
	}
        for (int i = 0; i < s.length(); i++) { 
	    if (count[s.charAt(i)] == 1) return i;
	}
        return -1;
    }
}


// Same with the above method but more concise using for-each method
public class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
	    count[c]++;
	}
        for (char c : s.toCharArray()) {
            if (count[c] == 1) return s.indexOf(c);
	}
        return -1;
    }
}

// O(n) time and O(n) space using hashmap
public class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
	    }
        }
        for (char c : s.toCharArray()) {
            if(map.get(c) == 1) return s.indexOf(c);
	}
        return -1;
    }
}
