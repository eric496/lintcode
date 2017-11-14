/*
Given two strings s and t, determine if they are isomorphic.
Two strings are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Notice
    You may assume both s and t have the same length.

Example
    Given s = "egg", t = "add", return true.
    Given s = "foo", t = "bar", return false.
    Given s = "paper", t = "title", return true.
*/

/*
Thought process:
    Use two arrays: Use characters in the strings as indices, and index of first apperance of that character as values.
                    At each iteration, compare the values whose indices are the characters from two strings. Return false if they do not match. 
*/

// O(n) time and O(n) space - with two hash maps
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        int n = s.length();
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int[] index1 = new int[n];
        int[] index2 = new int[n];
        for (int i = 0; i < n; i++){
            if (!map1.containsKey(s.charAt(i))) {
		map1.put(s.charAt(i), i);
	    }
            if (!map2.containsKey(t.charAt(i))) {
		map2.put(t.charAt(i), i);
	    }
        }
        for (int i = 0; i < n; i++) {
            index1[i] = map1.get(s.charAt(i));
            index2[i] = map2.get(t.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            if (index1[i] != index2[i]) return false;
        }
        return true;
    }
}

// O(n) time and O(1) space using two arrays
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return false;
	if (s.length() != t.length()) return false;
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i;
            m2[t.charAt(i)] = i;
        }
        return true;
    }
}
