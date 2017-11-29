/*
Determine the number of bits required to flip if you want to convert integer n to integer m.

Notice
    Both n and m are 32-bit integers.

Example
    Given n = 31 (11111), m = 14 (01110), return 2.
*/

/*
Thought process:
    XOR to check bits that needs flipping.
    i & (i-1) to clear the lowest bit.
    Count the number of non-zero bits.  
*/

class Solution {
    public int bitSwapRequired(int a, int b) {
        if (a == b) return 0;
        int count = 0;
        for (int i = a ^ b; i != 0; i &= i - 1) {
	    count++;
	}
        return count;
    }
}
