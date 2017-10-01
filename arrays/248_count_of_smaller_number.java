/*
Give you an integer array (index from 0 to n-1, where n is the size of this array, value from 0 to 10000) and an query list. For each query, give you an integer, return the number of element in the array that are smaller than the given integer.

Notice
    We suggest you finish problem Segment Tree Build and Segment Tree Query II first.

Example
    For array [1,2,7,8,5], and queries [1,8,5], return [0,4,2]

Challenge
    Could you use three ways to do it.
        Just loop
        Sort and binary search
        Build Segment Tree and Search.
*/

/*
Thought process:
    1. Sort the array and use binary search.
*/

public class Solution {
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        Arrays.sort(A);
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int q : queries) res.add(binarySearch(A, q));
        return res;
    }
    
    private int binarySearch(int[] A, int val) {
        int start = 0, end = A.length - 1;
        int res = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= val) {
                end = mid - 1;
            } else {
                res = mid + 1;
                start = mid + 1;
            }
        }
        return res;
    }
}
