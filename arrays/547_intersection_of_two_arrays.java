/*
Given two arrays, write a function to compute their intersection.

Notice
    Each element in the result must be unique.
    The result can be in any order.

Example
    Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Challenge
    Can you implement it in three different algorithms?
*/

/*
Thought process:
    1. Use two sets. One pass stores all unique values from the first array in the first set.
       The second pass stores all intersection values of both arrays in the second set.
       Third pass copy values from set to array.
    2. Sort the arrays first, then use two pointers to find all intersection values. 
    3. Sort one of the arrays, then use binary search to find intersection values.
*/

// O(n) time and O(n) space
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums1) {
	    set.add(n);
	}
        Set<Integer> intersect = new HashSet<>();
        for (int n : nums2) {
            if (set.contains(n)) {
		intersect.add(n);
	    }
	}
        int[] result = new int[intersect.size()];
        int ix = 0;
        for (int n : intersect) {
	    result[ix++] = n;
	}
        return result;
    }
}

// O(n) time and O(n) space 
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int ix1 = 0, ix2 = 0;
        while (ix1 < nums1.length && ix2 < nums2.length) {
            if (nums1[ix1] < nums2[ix2]) {
                ix1++;
            } else if (nums1[ix1] > nums2[ix2]) {
                ix2++;
            } else { 
                set.add(nums1[ix1]);
                ix1++;
                ix2++;
            }
        }
        int[] result = new int[set.size()];
        int ix = 0;
        for (int n : set) {
	    result[ix++] = n;
	}
        return result;
    }
}

// O(nlogn) time and O(n) space
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Set<Integer> set = new HashSet<>();
        for (int n : nums2) {
            if (binarySearch(nums1, n)) {
		set.add(n);
	    }
	}
        int[] result = new int[set.size()];
        int ix = 0;
        for (int n : set) {
	    result[ix++] = n;
	}
        return result;
    }
    
    private boolean binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if(nums[mid] < target) {
                low = mid + 1;
	    }
        }
        return false;
    }
}
