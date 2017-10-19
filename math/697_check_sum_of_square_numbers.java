/*
Given a integer c, your task is to decide whether there're two integers a and b such that a^2 + b^2 = c.

Example
    Given n = 5
    Return true // 1 * 1 + 2 * 2 = 5
    Given n = -5
    Return false
*/

public class Solution {
    public boolean checkSumOfSquareNumbers(int num) {
        for (long a = 0; a * a <= num; a++) {
            int b = num - (int)(a * a);
            if (binarySearch(0, b, b)) return true;
        }
        return false;
    }
    
    public boolean binarySearch(long s, long e, int n) {
        if (s > e) return false;
        long mid = s + (e - s) / 2;
        if (mid * mid == n) return true;
        if (mid * mid > n) return binarySearch(s, mid - 1, n);
        return binarySearch(mid + 1, e, n);
    }
}
