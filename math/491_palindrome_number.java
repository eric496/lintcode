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
    2. If string conversion is not allowed, then reverse the integer which is similar to 413. 
       Do until n equals 0:
           Take the digit at the unit place by n % 10, add it to the reverse number. 
           The reverse number from last step needs to move one place higher by multiplication of 10.
           The last digit is removed by n / 10 for next iteration.
*/

// convert to string and check palindrome
public class Solution {
    public boolean isPalindrome(int num) {
        String s = String.valueOf(num);
        for (int i = 0, j = s.length()-1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
	}
        return true;
    }
}

// math operation to reverse integer
public class Solution {
    public boolean isPalindrome(int num) {
        if (num < 0 || (num != 0 && num % 10 == 0)) return false;
        if (num == 0) return true;
        int reverse = 0, n = num; 
        while (n != 0) {
            reverse = n % 10 + reverse * 10;
            n /= 10;
        }
        return reverse == num ? true : false;
    }
}
