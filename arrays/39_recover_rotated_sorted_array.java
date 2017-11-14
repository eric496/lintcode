/*
Given a rotated sorted array, recover it to sorted array in-place.

Clarification
    What is rotated array?
        For example, the orginal array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]

Example
    [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]

Challenge
    In-place, O(1) extra space and O(n) time.
*/

/*
Thought process:
    Find where the head of the sorted array meets the end of the array (the first element whose value is greater than the next element).
    Split the array into two parts, each a sorted subarray. Use three-step reversal:
        1) Reverse the first part of the array.
        2) Reverse the second part of the array
        After this step, the array is already sorted, but in descending order.
        3) Reverse the entire array to make it in ascending order. 
*/

public class Solution {
    public void recoverRotatedSortedArray(List<Integer> nums) {
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i+1)) {
                reverse(nums, 0, i);
                reverse(nums, i+1, nums.size()-1);
                reverse(nums, 0, nums.size()-1);
            }
        }
    }

    public void reverse(List<Integer> nums, int low, int high) {
        while (low < high) {
            int temp = nums.get(low);
            nums.set(low, nums.get(high));
            nums.set(high, temp);
            low++;
            high--;
        }    
    }
}
