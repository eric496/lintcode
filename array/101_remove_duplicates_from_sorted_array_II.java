/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],
Your function should return length = 5, and A is now [1,1,2,2,3].
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for(int n : nums) {
            if(count < 2 || n != nums[count-2]) nums[count++] = n;
        }
        return count;
    }
}

//Generalization: what if most k duplicates are allowed?
public class Solution {
    public removeDuplicates(int[] nums, int k) {
        if(nums.length <= k) return nums.length;
        int i = 1, j = 1, cnt = 1;
        while(j < nums.length) {
            if(nums[j] != A[j-1]) {
                cnt = 1;
                A[j++] = A[j];
            } else {
                if(cnt < k) {
                    A[i++] = A[j];
                    cnt++;
                }
            }
            j++;
        }
        return i;
    }
}
