/*
Check a positive number is a palindrome or not.
A palindrome number is that if you reverse the whole number you will get exactly the same number.

Notice
    It's guaranteed the input number is a 32-bit integer, but after reversion, the number may exceed the 32-bit integer.

Example
    11, 121, 1, 12321 are palindrome numbers.
    23, 32, 1232 are not palindrome numbers.
*/

/*
Thought process:
    1. Convert to string, then it becomes similar to 415. Valid Palindrome
    2. If conversion is not allowed, then the solution is similar to 
*/

// convert to string and check if it is a valid palindrome
public class Solution {
    public boolean isPalindrome(int num) {
        String s = String.valueOf(num);
        for(int i = 0, j = s.length()-1; i < j; i++, j--) if(s.charAt(i) != s.charAt(j)) return false;
        return true;
    }
}

// The method to flip a number: take the remainder of n divided by 10 plus result multiplied by 10 to update result until n reaches 0. Update n by n/10 as well.
public class Solution {
    public boolean isPalindrome(int num) {
        if(num < 0) return false;
        if(num == 0) return true;
        int result = 0;
        int n = num; 
        while(n != 0) {
            result = n % 10 + result * 10;
            n /= 10;
        }
        if(result == num) return true;
        return false;
    }
}
