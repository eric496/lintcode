/*
Given a list, each element in the list can be a list or integer. flatten it into a simply list with integers.

Notice
If the element in the given list is a list, it can contain list too.

Example
Given [1,2,[1,2]], return [1,2,1,2].
Given [4,[3,[2,[1]]]], return [4,3,2,1].
*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

/*
Thought process
1. Since it is a problem of flattening a nested list, it is intuitive to think about recursive flatten.
2. For non-recursive solution, we will use stack. Push all elements into a stack. Loop through the stack, 
   if current element is a number, add to the result list, if not flatten it and push all the inner elements into the stack.
*/

//recursion
public class Solution {
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        if(nestedList == null) return null;
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(NestedInteger i : nestedList) {
            if(i.isInteger()) {
                res.add(i.getInteger());
            } else {
                res.addAll(flatten(i.getList()));
            }
        }
        return res;
    }
}

//non-recursion
public class Solution {
    public void pushStack(Stack<NestedInteger> stack, List<NestedInteger> nl) {
        for(int i = nl.size() - 1; i >= 0; i--) stack.push(nl.get(i));
    }
    
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = nestedList.size() - 1; i >= 0; i--) stack.push(nestedList.get(i));
        while(!stack.isEmpty()) {
            if(stack.peek().isInteger()) {
                res.add(stack.pop().getInteger());
            } else {
                pushStack(stack, stack.pop().getList());
            }
        }
        return res;
    }
}
