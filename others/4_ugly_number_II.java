/*
Ugly number is a number that only have factors 2, 3 and 5.
Design an algorithm to find the nth ugly number. The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...

Notice
    Note that 1 is typically treated as an ugly number.

Example
    If n=9, return 10.

Challenge
    O(n log n) or O(n) time.
*/

public class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i = 1; i < n; i++){
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if(factor2 == min) factor2 = 2 * ugly[++index2];
            if(factor3 == min) factor3 = 3 * ugly[++index3];
            if(factor5 == min) factor5 = 5 * ugly[++index5];
        }
        return ugly[n-1];
    }
}
