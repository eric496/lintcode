/*
Implement an algorithm to determine if a string has all unique characters.

Example
Given "abc", return true.
Given "aab", return false.
*/

public class Solution {
    public boolean isUnique(String str) {
        if(str == null || str.length() == 0) return false;
        int[] count = new int[256];
        for(int i = 0; i < str.length(); i++) {
            count[(int) str.charAt(i)]++;
            if(count[(int) str.charAt(i)] > 1) return false;
        }
        return true;
    }
}
