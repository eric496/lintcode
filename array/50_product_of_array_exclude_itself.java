/*
Given an integers array A.
Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B WITHOUT divide operation.

Example
For A = [1, 2, 3], return [6, 3, 2].
*/

public class Solution {
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> result = new ArrayList<Long>();
        if(A == null || A.size() == 0) return result;
        for(int i = 0; i < A.size(); i++) {
            long mul = 1;
            for(int j = 0; j < A.size(); j++) if(i != j) mul *= A.get(j);
            result.add(mul);
        }
        return result;
    }
}
