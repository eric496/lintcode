/*
Determine the number of bits required to flip if you want to convert integer n to integer m.

Notice
    Both n and m are 32-bit integers.

Example
    Given n = 31 (11111), m = 14 (01110), return 2.
*/

/*
Thought process:
    1. 
*/

class Solution {
    public int bitSwapRequired(int a, int b) {
        if(a == b) return 0;
        int n = a ^ b;
        int count = 0;
        while(n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
