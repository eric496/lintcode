/*
Reverse digits of an integer. Returns 0 when the reversed integer overflows (signed 32-bit integer).

Example
    Given x = 123, return 321
    Given x = -123, return -321
*/

/*
Thought process:
    1. Check integer overflow, use long integer to store intermediate value.
    2. At the beginning of each loop, raise current number to 1 higher place by multiplying 10.
       Then add new unit place digit by adding n % 10. Remember to reduce n to n/10 for next digit.
*/

public class Solution {
    public int reverseInteger(int n) {
        if(n < Integer.MIN_VALUE || n > Integer.MAX_VALUE) return 0;
        long result = 0;
        while(n != 0) {
            result = n % 10 + result * 10;
            n /= 10;
        }
        if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) return 0;
        return (int)result;
    }
}

