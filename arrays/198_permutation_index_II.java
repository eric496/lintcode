/*
Given a permutation which may contain repeated numbers, find its index in all the permutations of these numbers, which are ordered in lexicographical order. The index begins at 1.

Example
    Given the permutation [1, 4, 2, 2], return 3.
*/

public class Solution {
    public long permutationIndexII(int[] A) {
        if (A == null || A.length == 0) return 0L;
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        long index = 1, fact = 1, multiFact = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            if (counter.containsKey(A[i])) {
                counter.put(A[i], counter.get(A[i]) + 1);
                multiFact *= counter.get(A[i]);
            } else {
                counter.put(A[i], 1);
            }

            int rank = 0;
            for (int j = i + 1; j < A.length; j++)
                if (A[i] > A[j]) rank++;
            index += rank * fact / multiFact;
            fact *= (A.length - i);
        }
        return index;
    }
}
