/*
Given a integer k, find the sum of first k even-length palindrome numbers.
Even length here refers to the number of digits of a number is even.

Example
    Given k = 3, return 66 // 11 + 22 + 33 = 66 (Sum of first three even-length palindrome numbers)
    Given k = 10, return 1496
    // 11 + 22 + 33 + 44 + 55 + 66 + 77 + 88 + 99 + 1001 = 1496
*/

/*
Thought process:
    The first even-length palindrome number is 11, the second 22, ..., the 15th 1551, ... , the 30th 3003. Observe that the nth palindrome number is just n + reverse(n)
*/

public class Solution {
    public int sumKEven(int k) {
        int sum = 0;
        for (int i = 1; i <= k; i++) {
            String rev = reverse(Integer.toString(i));
            String str = Integer.toString(i) + rev;
            sum += Integer.parseInt(str);
        }
        return sum;
    }
    
    private String reverse(String str) {
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();
    }
}
