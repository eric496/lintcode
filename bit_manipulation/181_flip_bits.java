/*
Determine the number of bits required to flip if you want to convert integer n to integer m.

Notice
    Both n and m are 32-bit integers.

Example
    Given n = 31 (11111), m = 14 (01110), return 2.
*/

/*
Thought process:
    Brian Kernighan’s Algorithm:
    Subtraction of 1 from a number toggles all the bits (from right to left) till the rightmost set bit(including the righmost set bit). 
    So if we subtract a number by 1 and do bitwise & with itself (n & (n-1)), we unset the righmost set bit. 
    If we do n & (n-1) in a loop and count the no of times loop executes we get the set bit count.
    (source: https://www.geeksforgeeks.org/count-set-bits-in-an-integer/), see another explanation: http://www.techiedelight.com/brian-kernighans-algorithm-count-set-bits-integer/
*/

class Solution {
    public int bitSwapRequired(int a, int b) {
        if (a == b) return 0;
        int count = 0, flipBits = a ^ b;
        while (flipBits != 0) {
            flipBits &= flipBits - 1;
            count++;
        }
        return count;
    }
}
