/*
Given 3*n + 1 numbers, every numbers occurs triple times except one, find it.

Example
    Given [1,1,2,3,3,3,2,2,4,1] return 4

Challenge
    One-pass, constant extra space.
*/

// method 1
public class Solution {
    public int singleNumberII(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int sum = 0;
            for(int j = 0; j < nums.length; j++) {
                if(((nums[j] >> i) & 1) == 1) {
                    sum++;
                    sum %= 3;
                }
            }
            if(sum != 0) ans |= sum << i;
        }
        return ans;
    }
}

// method 2
public class Solution {
    public int singleNumberII(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones;
    }
}
