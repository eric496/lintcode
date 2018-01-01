/*
Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.
(Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)

Notice
    Note: N is an integer in the range [0, 10^9].

Example
    Given N = 10, return 9
    Given N = 12345, return 12345
    Given N = 10000, return 9999
*/

public class Solution {
    public int monotoneDigits(int num) {
        char[] str = String.valueOf(num).toCharArray();
        int i = 1;
        while (i < str.length && str[i-1] <= str[i]) {
            i++;
        }
        while (0 < i && i < str.length && str[i-1] > str[i]) {
            str[--i]--;
        }
        for (int j = i + 1; j < str.length; j++) {
            str[j] = '9';
        }
        return Integer.parseInt(String.valueOf(str));
    }
}
