/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

Example
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are no
*/

public class Solution {
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c: s.toCharArray()) {
            if("([{".contains(String.valueOf(c))) {
                stack.push(c);
            } else {
                if(!stack.isEmpty() && isValid(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    private boolean isValid(char c1, char c2) {
        return (c1 == '(' && c2 == ')' || c1 == '[' && c2 == ']' || c1 == '{' && c2 == '}');
    }
}
