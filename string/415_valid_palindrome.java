/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Notice
Have you consider that the string might be empty? This is a good question to ask during an interview.
For the purpose of this problem, we define empty string as valid palindrome.

Example
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
*/

public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
    
        for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if(!isValid(s.charAt(i))) i++;
            if(!isValid(s.charAt(j))) j--;
            if(i > j) break;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
        }
        return true;
    }
    
    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
