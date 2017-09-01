/*
Given a unsorted array with integers, find the median of it.
A median is the middle number of the array after it is sorted.
If there are even numbers in the array, return the N/2-th number after sorted.

Example
Given [4, 5, 1, 2, 3], return 3.
Given [7, 9, 4, 5], return 5.
*/

public class Solution {
    public int median(int[] nums) {
        int len = nums.length;
        quicksort(nums, 0, nums.length - 1);
        if(len % 2 == 0) {
            return nums[len / 2 - 1];
        } else {
            return nums[len / 2];
        }
    }
    
    public void quicksort(int[] A, int low, int high) {
        if(A.length == 0 || A.length == 1 || A == null) return;
        int pivot = A[low + (high - low) / 2];
        int i = low;
        int j = high;
        while(i <= j) {
            while(A[i] < pivot) i++;
            while(A[j] > pivot) j--;
            if(i <= j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
                j--;
            }
        }
        if(low < j) quicksort(A, low, j);
        if(i < high) quicksort(A, i, high);
    }
}
