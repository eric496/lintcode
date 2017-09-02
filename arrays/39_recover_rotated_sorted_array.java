/*
Given a rotated sorted array, recover it to sorted array in-place.

Clarification
What is rotated array?
    For example, the orginal array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]

Example
[4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
*/

/*
Thought process
1. 3-step reversal to solve it in place. 
   Firstly, find the verge where the head of the sorted array meets the tail of the array.
   Second, split the array into two halves by the verge. Reverse the first and second half respectively.
   After this step, the array is already sorted, but in descending order.
   Lastly, reverse the entire array to get the ascending order. 
*/

public class Solution {
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        for(int i = 0; i < nums.size() - 1; i++) {
            if(nums.get(i) > nums.get(i + 1)) {
                reverse(nums, 0, i);
                reverse(nums, i + 1, nums.size() - 1);
                reverse(nums, 0, nums.size() - 1);
            }
        }
    }
    
    public void reverse(ArrayList<Integer> nums, int start, int end) {
	while(start < end) {
	    int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
	    start++;
	    end--;
	}        
    }
}
