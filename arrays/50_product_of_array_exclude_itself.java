/*
Given an integers array A.
Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B WITHOUT divide operation.

Example
    For A = [1, 2, 3], return [6, 3, 2].
*/

/*
Thought process:
    1. Brute-force: nested loop 
    2. Forward-backward traversal: 
           The forward traversal will calculate the multiplication of all elements left to the current element. 
           The backward traversal will calculate the multiplication of all elements right to the current element.
           Update the each element in the result list during the backward traversal.
*/

// O(n^2) time by brute-force
public class Solution {
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> result = new ArrayList<Long>();
        if(A == null || A.size() == 0) return result;
        for(int i = 0; i < A.size(); i++) {
            long mul = 1;
            for(int j = 0; j < A.size(); j++) 
                if(i != j) mul *= A.get(j);
            result.add(mul);
        }
        return result;
    }
}

// O(n) time and O(1) space by forward-backward traversal
public class Solution {
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        if(A.size() == 0 || A == null) return null;
        ArrayList<Long> result = new ArrayList<Long>();
        long leftMul = 1, rightMul = 1;
        for (int i = 0; i < A.size(); i++) {
            // add before update leftMul
            result.add(leftMul);
            leftMul *= A.get(i);
        }
        for (int j = A.size() - 1; j >= 0; j--) {
            // add before update rightMul
            result.set(j, result.get(j)*rightMul);
            rightMul *= A.get(j);
        }
        return result;
    }
}
