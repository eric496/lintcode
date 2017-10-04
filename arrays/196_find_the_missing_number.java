/*
Given an array contains N numbers of 0 .. N, find which number doesn't exist in the array.

Example
    Given N = 3 and the array [0, 1, 3], return 2.

Challenge
    Do it in-place with O(1) extra memory and O(n) time.
*/

// bit manipulation
public class Solution {
    public int findMissing(int[] nums) {
        int xor = 0, i = 0;
        for(i = 0; i < nums.length; i++) xor = xor ^ i ^ nums[i];
        return xor ^ i;
    }
}

// calculate sum by n * (n + 1)
public class Solution {
    public int findMissing(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for(int num : nums) sum -= num;
        return sum;
    }
}

// binary search
public class Solution {
    public int findMissing(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        Arrays.sort(nums);
        int low = 0, high = nums.length;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
