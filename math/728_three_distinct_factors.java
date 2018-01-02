/*
Given a positive integer n (1 <= n <= 10^18). Check whether a number has exactly three distinct factors, return true if it has exactly three distinct factors, otherwise false.

Example
    Given n = 9, return true
    Number 9 has exactly three factors: 1, 3, 9, so return true.
    Given n = 10, return false
*/

/*
Thought process:
    number theory: every perfect square (x^2) always only has odd number of factors. Furthermore, if a perfect square is a prime number as well, then there are only three distinct factors.
    First, check if the number is a perfect square. Second, check if the number is a prime number 
*/

public class Solution {
    public boolean isThreeDisctFactors(long n) {
        long sq = (long)Math.sqrt(n);
        if (sq * sq != n) return false;
        return isPrime(sq) ? true : false;
    }
    
    private boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
