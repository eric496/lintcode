/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Notice
    You must not modify the array (assume the array is read only).
    You must use only constant, O(1) extra space.
    Your runtime complexity should be less than O(n^2).
    There is only one duplicate number in the array, but it could be repeated more than once.

Example
    Given nums = [5,5,4,3,2,1] return 5
    Given nums = [5,4,4,3,2,1] return 4
*/

/*
Thought process: 
    1. Sort the array and iterate it to find the duplicate by checking the equality of each two successive elements. 
    2. http://keithschwarz.com/interesting/code/?dir=find-duplicate
*/

// O(n) time and O(1) space
public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) return -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) return nums[i];;
        }
        return -1;
    }
}

// O(n) time and O(1) space
public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) return -1;
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
