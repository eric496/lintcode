/*
Check a positive number is a palindrome or not.
A palindrome number is that if you reverse the whole number you will get exactly the same number.

Notice
    It's guaranteed the input number is a 32-bit integer, but after reversion, the number may exceed the 32-bit integer.

Example
    11, 121, 1, 12321 are palindrome numbers.
    23, 32, 1232 are not palindrome numbers.
*/

public class Solution {
    public boolean isPalindrome(int num) {
        String s = String.valueOf(num);
        for(int i = 0, j = s.length()-1; i < j; i++, j--) if(s.charAt(i) != s.charAt(j)) return false;
        return true;
    }
}
