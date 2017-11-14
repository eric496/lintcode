/*
Reverse digits of an integer. Returns 0 when the reversed integer overflows (signed 32-bit integer).

Example
    Given x = 123, return 321
    Given x = -123, return -321
*/

/*
Thought process:
    Check integer overflow, use long integer to store intermediate value.
    Do until n equals 0:
	1) Move the current result one place higher by multiplication of 10
        2) Add the current digit at ones place to the result (+ n % 10)
        3) Move n one place lower by removing the ones place (n / 10)
    Check integer overflow again.
*/

public class Solution {
    public int reverseInteger(int n) {
        if (n < Integer.MIN_VALUE || n > Integer.MAX_VALUE) return 0;
        long result = 0;
        while (n != 0) {
            result = n % 10 + result * 10;
            n /= 10;
        }
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) return 0;
        return (int)result;
    }
}

