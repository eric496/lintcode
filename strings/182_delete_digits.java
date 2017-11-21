/*
Given string A representative a positive integer which has N digits, remove any k digits of the number, the remaining digits are arranged according to the original order to become a new positive integer.
Find the smallest integer after remove k digits.
N <= 240 and k <= N,

Example
    Given an integer A = "178542", k = 4
    return a string "12"
*/

/*
Thought process:
    There are (n-k) digits remained after removal of k digits. For the remaining (n-k) digits, we would like to find the digits at  
    higher places as small as possible. This can be done by comparing each digit with its previous digits and always store the smaller one.
    Use a stack to perform this. Iterate the digits, if the current digit is smaller than the top digit on the stack, pop the top digit and 
    keep the delete count updated. Push the current digit onto the stack at each iteration. 
    Remember to check the corner cases like "1111" (delete counter is greater than 0) and "0200" where the heading zeroes should be removed.
*/

public class Solution {
    public String DeleteDigits(String A, int k) {
        int n = A.length();
        if (k == n) return "0";
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (k > 0 && !s.isEmpty() && s.peek() > A.charAt(i)) {
                s.pop();
                k--;
            }
            s.push(A.charAt(i));
        }
        // handle corner cases like "11111"
        while (k > 0) {
            s.pop();
            k--;
        }
        StringBuffer sb = new StringBuffer();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        while(sb.length() > 1 && sb.charAt(sb.length()-1) == '0') {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.reverse().toString();
    }
}
