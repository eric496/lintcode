/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Notice
    Have you consider that the string might be empty? This is a good question to ask during an interview.
    For the purpose of this problem, we define empty string as valid palindrome.

Example
    "A man, a plan, a canal: Panama" is a palindrome.
    "race a car" is not a palindrome.

Challenge
    O(n) time without extra space.
*/

/*
Thought process:
    1. Without using extra space, we can use a head and a tail pointers.
       Firstly, check if the head and tail elements are valid alphanumeric values. If not, move the pointer by a step.
       Second, if both elements are valid, check if they are equal. If not, it is not a valid palindrome,
       otherwise, move both pointers by a step respectively.
*/

// O(n) time and O(1) space
public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        int start = 0, end = s.length() - 1;
        while(start < end) {
            if(!isValid(s.charAt(start))) start++;
            if(!isValid(s.charAt(end))) end--;
            if(isValid(s.charAt(start)) && isValid(s.charAt(end))) {
                if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) return false;
                start++;
                end--;
            }
        }
        return true;
    }
    
    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
