/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example
    Given num = 38.
    The process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return 2.

Challenge
    Could you do it without any loop/recursion in O(1) runtime?
*/

// method 1
public class Solution {
    public int addDigits(int num) {
        if (num < 10) return num;
        int sum = num;
        while (sum > 9) {
            num = sum;
            sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
        }
        return sum;
    }
}

// method 2
public class Solution {
    public int addDigits(int num) {
	if (num < 10) return num;
        while (num / 10 != 0) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            // update num value by its digit sum
            num = sum;
        }
        return num;
    }
}

// check out congruence formula at https://en.wikipedia.org/wiki/Digital_root#Congruence_formula
public class Solution {
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}
