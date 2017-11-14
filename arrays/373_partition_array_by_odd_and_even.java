/*
Partition an integers array into odd number first and even number second.

Example
    Given [1, 2, 3, 4], return [1, 3, 2, 4]

Challenge
    Do it in-place.
*/

/*
Thought process
     Two pointers: 
         1) Does not keep relative order: one starting at head, the other at end, swap elements when the head pointer at a non-odd value AND the tail pointer at a non-even value.
            Remember to check if (start < end) in each iteration, because head pointer can overstep the end pointer in the corner case.
         2) Keep relative order: similar to 539. Move Zeroes. 
*/

// relative order does not matter
public class Solution {
    public void partitionArray(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int head = 0;
        int tail = nums.length - 1;
        while (head < tail) {
            while (nums[head] % 2 == 1) head++;
            while (nums[tail] % 2 == 0) tail--;
            if (head < tail) {
                int temp = nums[head];
                nums[head] = nums[tail];
                nums[tail] = temp;    
                head++;
                tail--;
            }
        }
    }
}

// keep relative order
public class Solution {
    public void partitionArray(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                swap(nums, pos, i);
                pos++;
            }
        }
    }
    
    private void swap(int[] nums, int ixa, int ixb) {
        int temp = nums[ixa];
        nums[ixa] = nums[ixb];
        nums[ixb] = temp;
    }
}
