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
        if(s == null || s.length() == 0) return s;
        Stack<String> str = new Stack<String>();
        Stack<Integer> count = new Stack<Integer>();
        String result = "";
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
                continue;
            }
            if (Character.isLetter(c)){
                if (str.isEmpty()) {
                    result += c;
                } else { 
                    str.push(str.pop() + c);
                }
                continue;
            }
            if (c == '[') {
                count.push(num);
                num = 0;
                str.push(""); 
                continue;
            }
            if (c == ']') {
                String t = "";
                String temp = str.pop();
                int dup = count.pop();
                for (int k = 0; k < dup; k++) {
                    t += temp;
                }
                if (str.isEmpty()) {
                    result += t;
                } else { 
                    str.push(str.pop() + t);
                } 
            }
        }
        return result;
    }
}
