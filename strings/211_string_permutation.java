/*
Given two strings, write a method to decide if one is a permutation of the other.

Example
abcd is a permutation of bcad, but abbe is not a permutation of abe
*/

/*
Thought process:
    1. Same to 158
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
        for (int n : count) if (n != 0) return false;
        return true;
    }
}
