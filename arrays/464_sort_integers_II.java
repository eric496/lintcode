/*
Given an integer array, sort it in ascending order. Use quick sort, merge sort, heap sort or any O(nlogn) algorithm.

Example
Given [3, 2, 1, 4, 5], return [1, 2, 3, 4, 5].
*/

/*
Thought process:
    This is a review of all the efficient sorting algorithms with a time complexity of O(nlogn).
    1. Quicksort
    2. Mergesort
    3. Heap sort
*/

public class Solution {
    public void sortIntegers2(int[] A) {
        quickSort(A, 0, A.length - 1);
    }
    
    private void quickSort(int[] A, int start, int end) {
        if(start >= end) return;
        int left = start, right = end; 
        int pivot = A[start + (end - start) / 2];
        while(left <= right) {
            while(left <= right && A[left] < pivot) left++;
            while(left <= right && A[right] > pivot) right--;
            if(left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
}
