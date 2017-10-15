/*
Given a list of integers, which denote a permutation.
Find the previous permutation in ascending order.

Notice
    The list may contains duplicate integers.

Example
    For [1,3,2,3], the previous permutation is [1,2,3,3]
    For [1,2,3,4], the previous permutation is [4,3,2,1]
*/

public class Solution {
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
	int len = nums.size();
	if(len <= 1) return nums;
	int i = len - 1;
	while(i > 0 && nums.get(i) >= nums.get(i-1)) i--;
	swapList(nums, i, len - 1);     
	if (i != 0) {
	    int j = i;
	    while(nums.get(j) >= nums.get(i-1)) j++;
	    swapItem(nums, j, i-1);
	}
	return nums;
    }
    
    public void swapItem(ArrayList<Integer> nums, int i, int j) {
	Integer tmp = nums.get(i);
	nums.set(i, nums.get(j));
	nums.set(j, tmp);
    }
	
    public void swapList(ArrayList<Integer> nums, int i, int j) {
	while (i < j) {
	    swapItem(nums, i, j);
	    i++; 
	    j--;
        }
    }
}
