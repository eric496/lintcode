/*
Given an integer array, sort it in ascending order. Use selection sort, bubble sort, insertion sort or any O(n2) algorithm.

Example
Given [3, 2, 1, 4, 5], return [1, 2, 3, 4, 5].
*/

/*
Thought process:
    This is a review of all the brute-force sorting algorithms with a time complexity of O(n2).
    1. Bubble sort
    2. Selection sort
    3. Insertion sort
*/

public class Solution {
    public void sortIntegers(int[] A) {
        for(int i = 0; i < A.length; i++) {
            int min = i;
            for(int j = i + 1; j < A.length; j++) {
                if(A[j] < A[min]) iMin = j;
            }
            if(A[min] < A[i]) {
                int temp = A[i];
                A[i] = A[min];
                A[min] = temp;
            }
        }
    }
}