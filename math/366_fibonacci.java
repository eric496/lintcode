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
    1. Recursive solution:
           Base case: return 0 when n equals 1; return 1 when n equals 2.
           Recursive steps: the current value equals addition of the previous two values.
    2. Iterative solution:
           Use three pointers to represent the current value, the previous value, and the value prior to the previous value.
           Starting at the 3rd element, iterately update the current, the previous, and the value prior to the previous.   
*/

// recursive (it will cause TLE) 
class Solution {
    public int fibonacci(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}

// O(n) time and O(n) space by DP
public class Solution {
    public int fibonacci(int n) {
        if (n == 1) return 0;
	if (n == 2) return 1;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}

// O(n) time and O(1) space
public class Solution {
    public int fibonacci(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        int prevPrev = 0, prev = 1, cur = prevPrev + prev;
        for(int i = 3; i <= n; i++) {
            cur = prevPrev + prev;
            prevPrev = prev;
            prev = cur;
        }
        return cur;
    }
}
