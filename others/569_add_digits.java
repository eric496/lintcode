/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example
Given num = 38.
The process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return 2.
*/

public class Solution {
    public int addDigits(int num) {
        while(num / 10 != 0) {
            int ans = 0;
            while(num != 0) {
                ans += num % 10;
                num /= 10;
            }
            num = ans;
        }
        return num;
    }
}
