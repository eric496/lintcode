/*
Partition an integers array into odd number first and even number second.

Example
Given [1, 2, 3, 4], return [1, 3, 2, 4]
*/

/*
Thought process
1. An intuitive approach is to use two array lists: one to store the odd, the other the even. 
   This is O(n) time and O(n) space.
2. In-place solution: consider using two pointers: one from head to end, one the other way around.
   swap elements when the head pointer at a non-odd value AND the tail pointer at a non-even value. 
   NOTICE: the if(start < end) condition inside while loop is required, because head pointer could overstep the end pointer. 
*/

//O(n) space
public class Solution {
    public int[] partitionArray(int[] nums) {
	if(nums == null || nums.length == 0) return null;
	ArrayList<Integer> odd = new ArrayList<Integer>();
	ArrayList<Integer> even = new ArrayList<Integer>();
	for(int i : nums) {
	    if(i % 2 == 0) even.add(i);
	    if(i % 2 == 1) odd.add(i);
	}
	odd.addAll(even);
	int[] res = odd.toArray(new int[odd.size()]);
	return res;
    }
}

//In-place
public class Solution {
    public void partitionArray(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            while(nums[start] % 2 == 1) start++;
            while(nums[end] % 2 == 0) end--;
            if(start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;    
                start++;
                end--;
            }
        }
    }
}
