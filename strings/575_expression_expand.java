/*
Given an expression s includes numbers, letters and brackets. Number represents the number of repetitions inside the brackets(can be a string or another expression)．Please expand expression to be a string.

Example
    s = abc3[a] return abcaaa
    s = 3[abc] return abcabcabc
    s = 4[ac]dy, return acacacacdy
    s = 3[2[ad]3[pf]]xyz, return adadpfpfpfadadpfpfpfadadpfpfpfxyz

Challenge
    Can you do it without recursion?
*/

/*
Thought process:
*/

public class Solution {
    public String expressionExpand(String s) {
        if (s == null || s.length() == 0) return s;
        Stack<String> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();
        StringBuffer result = new StringBuffer();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (int)(c-'0');
                continue;
            }
            if (Character.isLetter(c)) {
                if (stack.isEmpty()) {
                    result.append(c);
                } else { 
                    stack.push(stack.pop()+c);
                }
                continue;
            }
            if (c == '[') {
                count.push(num);
                num = 0;
                stack.push(""); 
                continue;
            }
            if (c == ']') {
                StringBuffer t = new StringBuffer();
                String temp = stack.pop();
                int numDuplicates = count.pop();
                for (int k = 0; k < numDuplicates; k++) {
                    t.append(temp);
                }
                if (stack.isEmpty()) {
                    result.append(t.toString());
                } else { 
                    stack.push(stack.pop()+t);
                } 
            }
        }
        return result.toString();
    }
}
