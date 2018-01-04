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

/*
Thought process:
    The bitwise XOR operator is equivalent to arithmetic addition without carry. For example, a^b is just a+b without carry.
    Carry occurs when both bits are 1s, so a&b is where carry occurs and (a&b) << 1 is the result of carry only.
    The final result is just addition without carry and the carry itself only, which is just a + b = a ^ b + a & b << 1.
    Since + operator is not allowed, let b = carry << 1, which is the result with carry for each place, 
    and a = a ^ b which is the result of addition with carry at one place each time. 
    Repeat this using a while loop until b does not carry any more.     
*/

class Solution {
    public int aplusb(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a ^= b;
            b = carry << 1;
        }
        return a;
    }
}
