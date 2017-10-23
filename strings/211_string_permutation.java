/*
Given two strings, write a method to decide if one is a permutation of the other.

Example
    abcd is a permutation of bcad, but abbe is not a permutation of abe
*/

/*
Thought process:
    Same to 158. Two Strings Are Anagrams. Use an array or hashmap to store frequency of the characters from string A.
    Subtract the frequency of the characters from String B. If any value is not 0, which means there are more such character from A than from B or vice versa, return false.
    Otherwise, they are permutation to each other.
*/

// O(n) time and O(1) space - with an extra array
public class Solution {
    public boolean Permutation(String A, String B) {
        if(A == null && B == null) return true;
        if(A == null || B == null) return false;
        if(A.length() != B.length()) return false;
        int[] count = new int[256];
        for (int i = 0; i < A.length(); i++) {
            count[A.charAt(i)]++;
            count[B.charAt(i)]--;
        }
        for (int n : count) 
	    if (n != 0) return false;
        return true;
    }
}
