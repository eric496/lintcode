/*
Divide two integers without using multiplication, division and mod operator.
If it is overflow, return 2147483647

Example
    Given dividend = 100 and divisor = 9, return 11.
*/

public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        long result = 0;
        while(dvd >= dvs) {
            long tmp = dvs, multiple = 1;
            while(dvd >= (tmp << 1)) {
                tmp <<= 1;
                multiple <<= 1;
            }
            dvd -= tmp;
            result += multiple;
        }
        long res = (sign == 1 ? result : -result);
        return (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) ? Integer.MAX_VALUE : (int)res;
    }
}
