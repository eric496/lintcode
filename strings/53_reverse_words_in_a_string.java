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
    1. Use Java built-in methods in the following order
           1) Trim the string 
           2) Split the string by space
           3) Reverse the string array
           4) Join the words to form a new string       
    2. Split the string by space to form a string array. 
       Append the string element in backward order from the string array to a string buffer.
       Remove the last element from the string buffer, because we do not want to append a space to the last word.
       NOTICE we need to check the length of the string array after the split, because it might be zero, if the input contains only spaces.
*/

// method 1
public class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}

// method 2
public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return "";
        String[] words = s.split("\\s+");
	if(words.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) 
	    sb.append(words[i]).append(" ");
        return sb.substring(0, sb.length() - 1);
    }
}
