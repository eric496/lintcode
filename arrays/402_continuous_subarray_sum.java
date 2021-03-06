/*
Given an integer array, find a continuous subarray where the sum of numbers is the biggest. Your code should return the index of the first number and the index of the last number. (If their are duplicate answer, return anyone)

Example
    Give [-3, 1, 3, -3, 4], return [1,4].
*/

/*
Thought process:
    Similar to 41. Subarray Sum, but need to record indices.
    If the previous sum is negative, then the current element is the max sum. So update both first and last indices to current index.
    Otherwise, local max should include current element, and only update the last index to current index.
    Update global index if local max is greater than global max, and update the resulting indices accordingly.
    Remember to add values to result at first, or ArrayList set() method won't work for an empty arraylist.
*/

public class Solution {
    public List<Integer> continuousSubarraySum(int[] A) {
        List<Integer> result = new ArrayList<>();
        if (A == null || A.length == 0) return result;
        result.add(0);
        result.add(0);
        int first = 0, last = 0, localMax = A[0], globalMax = A[0];
        for (int i = 1; i < A.length; i++) {
            if (localMax < 0) {
                localMax = A[i];
                first = i;
                last = i;
            } else {
                localMax += A[i];
                last = i;
            }
            if (localMax > globalMax) {
                globalMax = localMax;
                result.set(0, first);
                result.set(1, last);
            }
        }
        return result;
    }
}
