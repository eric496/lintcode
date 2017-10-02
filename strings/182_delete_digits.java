/*
Given string A representative a positive integer which has N digits, remove any k digits of the number, the remaining digits are arranged according to the original order to become a new positive integer.
Find the smallest integer after remove k digits.
N <= 240 and k <= N,

Example
    Given an integer A = "178542", k = 4
    return a string "12"
*/

// Stack
public class Solution {
    public String DeleteDigits(String A, int k) {
        int n = A.length();
        if(k == n) return "0";
        Stack<Character> s = new Stack<Character>();
        for(int i = 0; i < n; i++) {
            while(k > 0 && !s.isEmpty() && s.peek() > A.charAt(i)) {
                s.pop();
                k--;
            }
            s.push(A.charAt(i));
        }
        while(k-- > 0) s.pop(); 
        StringBuffer sb = new StringBuffer();
        while(!s.isEmpty()) sb.append(s.pop());
        sb.reverse();
        while(sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.toString();
    }
}
