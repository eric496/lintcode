/*
Given a list of integers, which denote a permutation.
Find the next permutation in ascending order.

Notice
    The list may contains duplicate integers.

Example
    For [1,3,2,3], the next permutation is [1,3,3,2]
    For [4,3,2,1], the next permutation is [1,2,3,4]
*/

public class Solution {
    public int[] nextPermutation(int[] nums) {
        int n = nums.length - 1, p = -1, pv = 0;
        for(int i = n - 1; i >= 0; i--){
            if(nums[i] < nums[i + 1]) {
                p = i;
                pv = nums[i];
                break;
            }
        }    
        
        if(p == -1) {
            reverse(nums, 0, n);
            return nums;
        }
        
        for(int i = n; i >= 0; i--){
            if(nums[i] > pv){
              swap(nums, p, i);
              break;
            }
        }
        reverse(nums, p + 1, n);
        return nums;
    }
        
    void reverse(int[] nums, int s, int e){
        while(s < e) {
            swap(nums, s, e);
            s++;
            e--;
        }
    }
    
    void swap(int[] nums, int s, int e){
        int t = nums[s];
        nums[s] = nums[e];
        nums[e] = t;     
    }
}
