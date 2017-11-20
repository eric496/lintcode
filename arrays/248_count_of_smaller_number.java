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
    1. Just loop
    2. Sort the array and use binary search (return the index instead of the element).
*/

// O(n^2) time
public class Solution {
    public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        List<Integer> result = new ArrayList<>();
        for (int query : queries) {
            int sum = 0;
            for (int num : A) {
                if (num < query) {
                    sum++;
                }
            }
            result.add(sum);
        }
        return result;
    }
}

// O(logn) time
public class Solution {
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        Arrays.sort(A);
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int q : queries) {
            result.add(binarySearch(A, q));
        }
        return result;
    }

    private int binarySearch(int[] A, int val) {
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] >= val) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
