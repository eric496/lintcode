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
    Two pointers: One starting from the head, one starting from the end.
                  First, check if the head and tail elements are valid alphanumeric values. Keep moving pointers till they point to the first qualified values.
                  Second, check if they are equal (case insensitivity by convert all to upper or lower case). 
                  If not, it is not a valid palindrome. Otherwise, move both pointers to next elements and repeat the process until two pointers meet.
*/

// O(n) time and O(1) space
public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        int start = 0, end = s.length() - 1;
        while(start < end) {
            char c1 = s.charAt(start);
            char c2 = s.charAt(end);
            if(!isValid(c1)) start++;
            if(!isValid(c2)) end--;
            if(isValid(c1) && isValid(c2)) {
                if(!isSame(c1, c2)) return false;
                start++;
                end--;
            }
        }
        return true;
    }
    
    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
    
    private boolean isSame(char c1, char c2) {
        return Character.toLowerCase(c1) == Character.toLowerCase(c2) ? true : false;
    }
}
