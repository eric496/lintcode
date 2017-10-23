/*
Write a method anagram(s,t) to decide if two strings are anagrams or not.

Clarification
    What is Anagram?
    - Two strings are anagram if they can be the same after change the order of characters.

Example
    Given s = "abcd", t = "dcab", return true.
    Given s = "ab", t = "ab", return true.
    Given s = "ab", t = "ac", return false.

Challenge
    O(n) time, O(1) extra space
*/

/*
Thought process:
    Use an extra array (if ASCII) or hash map (if unicode or other encoding standards).
    Using an array counts towards O(1) space since it has fixed size.
*/

// O(n) time and O(1) space using an extra array
public class Solution {
    public boolean anagram(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        int[] count = new int[256];
        for(int i = 0; i < s.length(); i++) {
            count[(int)s.charAt(i)]++;
            count[(int)t.charAt(i)]--;
        }
        for(int n : count) {
            if(n != 0) return false;
        }
        return true;
    }
}

// O(n) time and O(n) space using a hash map
public class Solution {
    public boolean anagram(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for(char c: t.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) < 0) return false;
            } else {
                return false;
            }
        }
        return true;
    }
}
