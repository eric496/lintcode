/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

Example
    Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
    1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1

Challenge
    The replacement must be in-place, do not allocate extra memory.
*/

public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n > 1) {
            for (int i = n-2; i >= 0; i--) {  
                if (nums[i] < nums[i+1]) {
                    for (int j = n - 1; j > i; j--) {
                        if (nums[j] > nums[i]) {
                            swap(nums, i, j);
                            reverse(nums, i+1, nums.length-1);
                            return;
                        }
                    }
                }
            }  
        }
        reverse(nums, 0, nums.length-1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            swap(nums,i,j);
        }
    }
}
