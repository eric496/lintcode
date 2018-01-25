/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.

Example
    Given input array A = [1,1,2],
    Your function should return length = 2, and A is now [1,2].
*/

/*
Thought process:
    Two pointers: Create a unique value counter, which, at the same time,  serves as a position pointer.
                  Iterate the array, once the current element is different from the previous element of the position pointer, 
                  move the current element to where the current position pointer points to. Meanwhile, increment the position pointer.
*/

// O(n) time and O(1) space
public class Solution {
    public int removeDuplicates(int[] nums) {
	if (nums  == null) return 0;
        if (nums.length <= 1) return nums.length;
        // set count to 1 because there is at least one element
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[count-1]) {
                nums[count++] = nums[i];
	    }
        }
        return count;
    }
} 
