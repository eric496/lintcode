/*
Write a method anagram(s,t) to decide if two strings are anagrams or not.

Clarification
What is Anagram?
- Two strings are anagram if they can be the same after change the order of characters.

Example
Given s = "abcd", t = "dcab", return true.
Given s = "ab", t = "ab", return true.
Given s = "ab", t = "ac", return false.
*/

public class Solution {
    public boolean anagram(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) count[(int) s.charAt(i)]++;
        for (int i = 0; i < t.length(); i++) {
            count[(int) t.charAt(i)]--;
            if (count[(int) t.charAt(i)] < 0) return false;
        }
        return true;
    }
}
