/*
Write a program to check whether a given number is an ugly number`.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Notice
    Note that 1 is typically treated as an ugly number.

Example
    Given num = 8 return true
    Given num = 14 return false
*/

/*
Thought process:
    Divide the number by 2, 3, 5 recursively until it cannot be factored any further and check if the result equals 1.
    Can be done recursively or iteratively. 
*/

// recursive
public class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;
        if (num % 2 == 0) return isUgly(num/2);
        if (num % 3 == 0) return isUgly(num/3);
        if (num % 5 == 0) return isUgly(num/5);
        return false;
    }
}

// iterative
public class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;
        while (num >= 2 && num % 2 == 0) num /= 2;
        while (num >= 3 && num % 3 == 0) num /= 3;
        while (num >= 5 && num % 5 == 0) num /= 5;
        return num == 1;
    }
}
