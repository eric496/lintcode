/*
For an array A, if i < j, and A [i] > A [j], called (A [i], A [j]) is a reverse pair.
return total of reverse pairs in A.

Example
    Given A = [2, 4, 1, 3, 5] , (2, 1), (4, 1), (4, 3) are reverse pairs. return 3
*/

public class Solution {
    public long reversePairs(int[] A) {
        return reversePairsSub(A, 0, A.length-1);
    }
    
    private int reversePairsSub(int[] nums, int low, int high) {
        if (low >= high) return 0;
        int mid = low + (high - low) / 2;
        int result = reversePairsSub(nums, low, mid) + reversePairsSub(nums, mid+1, high);
        int i = low, j = mid + 1, k = 0, p = mid + 1;
        int[] merge = new int[high-low+1];
        while (i <= mid) {
            while (p <= high && nums[i] > nums[p]) {
                p++;
            }
            result += p - (mid + 1);
            while (j <= high && nums[i] >= nums[j]) {
                merge[k++] = nums[j++];
            }
            merge[k++] = nums[i++];
        }
        while (j <= high) {
            merge[k++] = nums[j++];
        }
        System.arraycopy(merge, 0, nums, low, merge.length);
        return result;
    }
}
