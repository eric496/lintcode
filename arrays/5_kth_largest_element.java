/*
Find K-th largest element in an array.

Notice
    You can swap elements in the array

Example
    In array [9,3,2,4,8], the 3rd largest element is 4.
    In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.

Challenge
    O(n) time, O(1) extra memory.
*/

// O(logn) time and O(1) space by sorting the array
class Solution {
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (k <= 0) return 0;
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

// O(n) time and O(1) space
class Solution {
    public int kthLargestElement(int k, int[] nums) {
        int n = nums.length;
        int p = quickSelect(nums, 0, n - 1, n - k + 1);
        return nums[p];
    }
    
    // return the index of the kth smallest number
    int quickSelect(int[] a, int lo, int hi, int k) {
        // use quick sort's idea
        // put nums that are <= pivot to the left
        // put nums that are  > pivot to the right
        int i = lo, j = hi, pivot = a[hi];
        while (i < j)
            if (a[i++] > pivot) swap(a, --i, --j);
        swap(a, i, hi);
        // count the nums that are <= pivot from lo
        int m = i - lo + 1;
        // pivot is the one!
        if (m == k) 
            return i;
        // pivot is too big, so it must be on the left
        else if (m > k) 
            return quickSelect(a, lo, i - 1, k);
        // pivot is too small, so it must be on the right
        else            
            return quickSelect(a, i + 1, hi, k - m);
    }
    
    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
