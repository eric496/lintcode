/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

Example
    Given sorted array A = [1,1,1,2,2,3],
    Your function should return length = 5, and A is now [1,1,2,2,3].
*/

/*
Thought process:
    Similar to 100. Remove Duplicates from sorted array. 
    The only difference is to check the equality of the current element and the element at [position pointer-2].
    Generalization:
        What if at most k duplicates are allowed?
        Same idea, but check equality at position pointer - k 
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length <= 2) return nums.length;
        int count = 2;
        for(int i = 2; i < nums.length; i++) {
            if(nums[i] != nums[count-2]) 
		nums[count++] = nums[i];
        }
        return count;
    }
}

//Generalization: what if at most k duplicates are allowed?
public class Solution {
    public removeDuplicates(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length <= k) return nums.length;
	int count = k;
        for(int i = k; i < nums.length; i++) {
  	    if(nums[i] != nums[count-k]) 
		nums[count++] = nums[i];
	}
	return count;
    }
}
