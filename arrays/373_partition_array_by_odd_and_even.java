/*
Partition an integers array into odd number first and even number second.

Example
    Given [1, 2, 3, 4], return [1, 3, 2, 4]

Challenge
    Do it in-place.
*/

/*
Thought process
     1. Use two lists to store odd and even elements separately. Return the concatenated list.
     2. Use two pointers: one starting at head, the other at end, swap elements when the head pointer at a non-odd value AND the tail pointer at a non-even value.
        Remember to check if(start < end) in each iteration, because head pointer can overstep the end pointer in the corner case. 
*/

// O(n) space
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
	int[] result = odd.toArray(new int[odd.size()]);
	return result;
    }
}

// in-place by two pointers but do not maintain the relative order within the odd and even numbers
public class Solution {
    public void partitionArray(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int head = 0;
        int tail = nums.length - 1;
        while(head < tail) {
            while(nums[head] % 2 == 1) head++;
            while(nums[tail] % 2 == 0) tail--;
            if(head < tail) {
                int temp = nums[head];
                nums[head] = nums[tail];
                nums[tail] = temp;    
                head++;
                tail--;
            }
        }
    }
}
