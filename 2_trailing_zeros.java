/*
Write an algorithm which computes the number of trailing zeros in n factorial.

Example
11! = 39916800, so the out should be 2
*/

class Solution {
    public long trailingZeros(long n) {
        long count = 0;
        while(n != 0) {
            n = n / 5;
            count += n;
        }
        return count;
    }
}
