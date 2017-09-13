/*
Find the Nth number in Fibonacci sequence.
A Fibonacci sequence is defined as follow:
    The first two numbers are 0 and 1.
    The i th number is the sum of i-1 th number and i-2 th number.
The first ten numbers in Fibonacci sequence is:
0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...

Notice
    The Nth fibonacci number won't exceed the max value of signed 32-bit integer in the test cases.

Example
    Given 1, return 0
    Given 2, return 1
    Given 10, return 34
*/

/*
Thought process:
    1. Be careful of the base case, different fibonacci sequence might start with different initial values, 
       such as 0 or 1.
    2. Similar to 111. Climbing stairs
*/

// recursive 
class Solution {
    public int fibonacci(int n) {
        if(n == 1) return 0;
        if(n == 2) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

// non-recursive
class Solution {
    public int fibonacci(int n) {
        if(n == 1) return 0;
        if(n == 2) return 1;
        int prevPrev = 0;
        int prev = 1;
        int cur = 0;
        for(int i = 3; i <= n; i++) {
            cur = prevPrev + prev;
            prevPrev = prev;
            prev = cur;
        }
        return cur;
    }
}
