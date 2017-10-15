/*
Implement pow(x, n).

Notice
    You don't need to care about the precision of your answer, it's acceptable if the expected answer and your answer 's difference is smaller than 1e-3.

Example
    Pow(2.1, 3) = 9.261
    Pow(0, 1) = 0
    Pow(1, 0) = 1

Challenge
    O(logn) time
*/

// O(logn) time
public class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        long absN = Math.abs((long)n);
        while(absN > 0) {
            if((absN & 1) == 1) ans *= x;
            absN >>= 1;
            x *= x;
        }
        return n < 0 ?  1 / ans : ans;
    }
}
