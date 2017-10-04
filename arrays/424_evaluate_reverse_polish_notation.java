/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Example
    ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
    ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

/*
Thought process:
    1. Use a stack, push integers into the stack, once we meet an arithmetic operator, 
       pop the top 2 elements and do the calculation and push the result back into the stack.
       Finally we have only one element in the stack which is the result.
    2. Notice for string comparison use .equals() method instead of "=="
*/

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        for(String token : tokens) {
            if(token.equals("+")) {
                s.push(s.pop() + s.pop());
            } else if(token.equals("-")) {
                int num = s.pop();
                s.push(s.pop() - num);
            } else if(token.equals("*")) {
                s.push(s.pop() * s.pop());
            } else if(token.equals("/")) {
                int num = s.pop();
                s.push(s.pop() / num);
            } else {
                s.push(Integer.parseInt(token));
            }
        }
        return s.pop();
    }
}
