/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.

Example
    Given input array A = [1,1,2],
    Your function should return length = 2, and A is now [1,2].
*/

/*
Thought process:
    Two pointers: Create a unique value counter, which is a position pointer as well.
                  Iterate the array, once the current element is different from the elemtent at the position pointer, move it to the position right to the position pointer. 
                  Meanwhile, increment the position pointer.
*/

// O(n) time and O(1) space
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
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
