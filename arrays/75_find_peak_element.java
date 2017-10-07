/*
There is an integer array which has the following features:
    The numbers in adjacent positions are different.
    A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
We define a position P is a peek if:
A[P] > A[P-1] && A[P] > A[P+1]
Find a peak element in this array. Return the index of the peak.

Notice
    It's guaranteed the array has at least one peak.
    The array may contain multiple peeks, find any of them.
    The array has at least 3 numbers in it.

Example
    Given [1, 2, 1, 3, 4, 5, 7, 6]
    Return index 1 (which is number 2) or 6 (which is number 7)

Challenge
    Time complexity O(logN)
*/

class Solution {
    public int findPeak(int[] A) {
        int low = 0, high = A.length - 1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(A[mid] < A[mid+1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}