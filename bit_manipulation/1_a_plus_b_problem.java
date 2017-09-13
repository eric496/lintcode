/*
Write a function that add two numbers A and B. You should not use + or any arithmetic operators.

Notice
    There is no need to read data from standard input stream. 
    Both parameters are given in function aplusb, 
    you job is to calculate the sum and return it.
 
Clarification
    Are a and b both 32-bit integers?
    Yes.
    Can I use bit operation?
    Sure you can.

Example
    Given a=1 and b=2 return 3
*/

class Solution {
    public int aplusb(int a, int b) {
        while(b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
