/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Notice
    Do not use any built-in library function such as sqrt.

Example
    For example:
    Given num = 16
    Returns True
*/

// Newton's method
public class Solution {
    public boolean isPerfectSquare(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num/x) >> 1;
        }
        return x * x == num;
    }
}
