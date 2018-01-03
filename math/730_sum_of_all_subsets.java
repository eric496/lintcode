/*
Given a number n, we need to find the sum of all the elements from all possible subsets of a set formed by first n natural numbers.

Example
    Given n = 2, return 6
    Possible subsets are {{1}, {2}, {1, 2}}. Sum of elements in subset is 1 + 2 + 1 + 2 = 6
    Given n = 3, return 24
    Possible subsets are {{1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}
    Sum of subsets is : 1 + 2 + 3 + (1 + 2) + (1 + 3) + (2 + 3) + (1 + 2 + 3)
*/

/*
Thought process:
    Every number from 1 to n appears exactly 2^(n-1) times. So the sum is (1+2+...+n) * 2^(n-1) which is n * (n+1) / 2 * 2^(n-1)
*/

public class Solution {
    public int subSum(int n) {
        if (n <= 1) return n;
        return (n * (n + 1) / 2 * (1 << (n - 1)));
    }
}
