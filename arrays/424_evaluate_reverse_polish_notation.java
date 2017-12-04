/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Example
    ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
    ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

/*
Thought process:
    Use a stack, push integers into the stack, once we meet an arithmetic operator, pop the top 2 elements, do the calculation and push the result back into the stack.
    Finally we have only one element in the stack which is the result. Notice we use .equals() method instead of "==" to compare value instead of reference.
    Calculation order matters for subtraction and division, so create temporary variables to store the first popped element.
*/

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop()+stack.pop());
            } else if (token.equals("-")) {
                int num = stack.pop();
                stack.push(stack.pop()-num);
            } else if (token.equals("*")) {
                stack.push(stack.pop()*stack.pop());
            } else if (token.equals("/")) {
                int num = stack.pop();
                stack.push(stack.pop()/num);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
