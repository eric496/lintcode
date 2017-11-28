/*
Given a integer c, your task is to decide whether there're two integers a and b such that a^2 + b^2 = c.

Example
    Given n = 5
    Return true // 1 * 1 + 2 * 2 = 5
    Given n = -5
    Return false
*/

/*
Thought process:
    Iterate all possible values of a, within each iteration, do a binary search for eligible b.
*/

// O(nlogn) time
public class Solution {
    public boolean checkSumOfSquareNumbers(int num) {
        for (long a = 0; a * a <= num; a++) {
            int b = num - (int)(a*a);
            if (binarySearch(0, b, b)) return true;
        }
        return false;
    }
    
    public boolean binarySearch(long low, long high, int n) {
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid == n) {
                return true;
            } else if (mid * mid > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
