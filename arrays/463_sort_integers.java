/*
Given an integer array, sort it in ascending order. Use selection sort, bubble sort, insertion sort or any O(n2) algorithm.

Example
    Given [3, 2, 1, 4, 5], return [1, 2, 3, 4, 5].
*/

/*
Thought process:
    This is a review of some common brute-force sorting algorithms with time complexity of O(n2).
    1. Bubble sort
    2. Insertion sort
    3. Selection sort
*/

// Bubble sort
public class Solution {
    public void sortIntegers(int[] A) {
        for(int i = 0; i < A.length - 1; i++) {
            for(int j = 0; j < A.length - i - 1; j++) {
                if(A[j] > A[j+1]) {
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
    }
}

// Insertion sort
public class Solution {
    public void sortIntegers(int[] A) {
        for(int i = 1; i < A.length; i++) {
            int key = A[i], j = i - 1;
            while(j >= 0 && A[j] > key) A[j+1] = A[j--];
            A[j+1] = key;
        }
    }
}

// Selection sort
public class Solution {
    public void sortIntegers(int[] A) {
        for(int i = 0; i < A.length; i++) {
            int min = A[i];
            int ixMin = i;
            for(int j = i+1; j < A.length; j++) {
                if(A[j] < min) {
                    min = A[j];
                    ixMin = j;
                }
            }
            int temp = A[i];
            A[i] = A[ixMin];
            A[ixMin] = temp;
        }
    }
}
