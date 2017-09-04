/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You may assume NO duplicates in the array.

Example
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

/*
Thought process:
    1. It is obvious to solve it using a for loop with O(n) time complexity. 
    2. Better solution: O(logn) time:
       Use binary search, but be careful about the edge case, we should include "=" 
       in the while condition.
    3. Think thoroughly of the corner cases (A == null etc.)
*/

//O(n) time
public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A == null) return -1;
        if(A.length == 0) return 0;
        if(A[0] >= target) return 0;
        if(A[A.length - 1] < target) return A.length;
        for(int i = 0; i < A.length - 1; i++) {
            if(A[i] < target && A[i + 1] >= target) return i + 1;
        }
        return -1;
    }
}

//O(logn) time
public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A == null) return -1;
        if(A.length == 0) return 0;
        if(A[0] >= target) return 0;
        if(A[A.length - 1] < target) return A.length;
        int low = 0, high = A.length - 1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(target == A[mid]) {
                return mid;
            } else if(target < A[mid]) {
                high = mid - 1;
            } else if(target > A[mid]) {
                low = mid + 1;
            }
        }
        return low;
    }
}
