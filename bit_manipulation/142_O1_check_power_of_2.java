/*
Using O(1) time to check whether an integer n is a power of 2.

Example
    For n=4, return true;
    For n=5, return false;
*/

/*
Thought process:
    O(1) time -> we should use bit operations.
    If an integer n is a power of 2, then there is only one 1 in its binary form. (n-1) is flipping all its bits. 
    n & (n-1) unsets n's rightmost set bit (which means switching its rightmost 1 to 0), which results in a sequence of zeroes if there is only one 1 in the binary form.
*/

class Solution {
    public boolean checkPowerOf2(int n) {
        if (n <= 0) return false;
        return (n & (n-1)) == 0 ? true : false;
    }
}
