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

/*
Thought process:
    1. Use Java built-in methods (trim, split, reverse etc.)
    2. Split the string by space to form a string array. 
       Append the string array backward element by element to a string buffer.
       Remove the first element in the string buffer which is a redundant space. 
       NOTICE we need to check the length of the string array after the split, 
       it could be zero, given the input is all spaces.
*/

// use java built-in methods
public class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}

//
public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return "";
        String[] words = s.split(" +");
	if(words.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) sb.append(words[i]).append(" ");
        return sb.substring(0, sb.length() - 1);
    }
}
