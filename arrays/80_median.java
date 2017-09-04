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
        if (nums == null || nums.length == 0) return -1;
        return quickSort(nums, 0, nums.length - 1, (nums.length + 1) / 2);
    }

    private int quickSort(int[] nums, int low, int high, int size) {
        if (low >= high) return nums[high];
        int mid = low;
        for (int i = low + 1; i <= high; i++) {
            if (nums[i] < nums[low]) {
                mid++;
                int temp = nums[mid];
                nums[mid] = nums[i];
                nums[i] = temp;
            }
        }
        int temp = nums[mid];
        nums[mid] = nums[low];
        nums[low] = temp;
        if (mid - low + 1 == size) {
            return nums[mid];
        } else if (mid - low + 1 > size) {
            return quickSort(nums, low, mid - 1, size);
        } else {
            return quickSort(nums, mid + 1, high, size - (mid - low + 1));
        }
    }
}
