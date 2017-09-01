/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.

Example
Given input array A = [1,1,2],
Your function should return length = 2, and A is now [1,2].
*/

/*
Thought process
1. Corner cases when the array is null or empty
2. The question requires not only counting the length but changing the array IN PLACE as well
*/

/*
O(n) time and O(1) space
loop through the integer array, compare each element with its previous element
if they are not the same, replace the count position with the current element
if they are the same, loop goes on but count position does not move
*/
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) nums[count++] = nums[i];
        }
        return count;
    }
} 
