/*
Given a list, each element in the list can be a list or integer. flatten it into a simply list with integers.

Notice
    If the element in the given list is a list, it can contain list too.

Example
    Given [1,2,[1,2]], return [1,2,1,2].
    Given [4,[3,[2,[1]]]], return [4,3,2,1].

Challenge
    Do it in non-recursive.
*/

/*
Thought process
    1. Recursive solution: since the array is in a nested structure, so we can repeatedly divide and conquar the sub structure by recursion.
           Base case: return null when current nested list is null.
           Recursive step: for each element in the current nested list, add it directly to result list if it is an integer.
                           Otherwise, recursively flatten the nested list and add all its elements to result list. 
    2. Iterative solution: use stack
           Push all elements into the stack in reverse order (in order to get the result in correct order)
           Iterate the stack, if the popped element is an integer, then add it to the result list directly.
           Otherwise it must be a list, then push all elements in the list into the stack in reverse order.             
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

// recursive
public class Solution {
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> result = new ArrayList<>();
        if (nestedList == null || nestedList.size() == 0) return result;
        for (NestedInteger i : nestedList) {
            if (i.isInteger()) {
                result.add(i.getInteger());
            } else {
                result.addAll(flatten(i.getList()));
            }
        }
        return result;
    }
}

// iterative
public class Solution {
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> result = new ArrayList<>();
        if (nestedList == null || nestedList.size() == 0) return result;
        Stack<NestedInteger> s = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            s.push(nestedList.get(i));            
        }
        while (!s.isEmpty()) {
            NestedInteger top = s.pop();
            if (top.isInteger()) {
                result.add(top.getInteger());
            } else {
                for (int i = top.getList().size() - 1; i >= 0; i--) {
                    s.push(top.getList().get(i));
                }
            }
        }
        return result;
    }
}
