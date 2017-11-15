/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

Example
    The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are no
*/

/*
Thought process:
    Use stack to pair the parentheses, if a character is '(', '{' or '[',
    then push it to the stack. Otherwise, check validity with the top element from the stack.
*/

public class Solution {
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c== '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && isValid(stack.peek(), c)) {
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

// a shorter and smarter solution 
public class Solution {
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
	    }
        }
        return stack.isEmpty();
    }
}
