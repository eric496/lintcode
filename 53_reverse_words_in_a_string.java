/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Clarification
    What constitutes a word?
    A sequence of non-space characters constitutes a word.
    Could the input string contain leading or trailing spaces?
    Yes. However, your reversed string should not contain leading or trailing spaces.
    How about multiple spaces between two words?
    Reduce them to a single space in the reversed string.
*/

public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return "";
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
            if(words[i] !=  "") sb.append(words[i]).append(" ");
        }
        if(sb.length() == 0) return "";
        return sb.substring(0, sb.length() - 1);
    }
}
