/*
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

Example
    Given "aacecaaa", return "aaacecaaa".
    Given "abcd", return "dcbabcd".
*/

/*
Thought process:
    1. Recursive 
    2. KMP
*/

// recursion
public class Solution {
    public String convertPalindrome(String str) {
        int j = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == str.charAt(j)) j += 1;
        }
        if (j == str.length()) return str; 
        String suffix = str.substring(j);
        return new StringBuffer(suffix).reverse().toString() + convertPalindrome(str.substring(0, j)) + suffix;
    }
}
