/*
Implement a stack with min() function, which will return the smallest number in the stack.
It should support push, pop and min operation all in O(1) cost.

Notice
    min operation will never be called if there is no number in the stack.

Example
    push(1)
    pop()   // return 1
    push(2)
    push(3)
    min()   // return 2
    push(1)
    min()   // return 1
*/

/*
Thought process:
    In order to make pop in O(1) cost, which means no iteration search for min after the min is popped, we should consider extra data structure. 
    Use two stacks, one to store all pushed values, the other one to store min so far. Keep operations (push, pop) synchronized for both stacks.
*/

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int number) {
        stack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);
        } else {
            minStack.push(Math.min(number, minStack.peek()));
        }
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    public int min() {
        return minStack.peek();
    }
}
