/*
Given a list of integers and find the smallest prime number that doesn't appear in this list.

Example
    Given a list [2,3,5,7,11,13,17,23,29]
    return 19
*/

public class Solution {
    public int firstMissingPrime(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 0 || nums[0] > 2) return 2;
        for (int i = 2; i < nums[0]; i++) {
            boolean flag = false;
            for (int k = 2; k <= Math.sqrt(k) + 1; k++) { 
                if (i % k == 0) {
            	    flag = true;
            	    break;
                }
            }
            if (flag == false) return i;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums[i] + 1; j < nums[i+1]; j++) {
       		boolean flag = false;
        	for (int k = nums[0]; k <= Math.sqrt(j); k++) {
        	    if (j % k == 0 ){
        		flag = true;
        		break;
        	    }
        	}
        	if (flag == false) return j;
            }
        }
        for (int i = nums[nums.length - 1] + 1;; i++) {
            boolean flag = false;
            for (int k = nums[0]; k <= Math.sqrt(i); k++) {
        	if (i % k == 0 ) {
        	    flag = true;
        	    break;
        	}
            }
            if (flag == false) return i;
        }
    }
}
