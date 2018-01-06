/*
Given two arrays, write a function to compute their intersection.

Notice
    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.

Example
    Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Challenge
    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to num2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/

/*
Thought process: 
    1. Similar to 547, but keep track of the number of appearance of each element by using 
       hash map instead of hash set to store <number, count> pairs.
    2. Similar to 547, use two pointers to iterate both arrays and store the intersection.
*/

// O(n) time and O(n) space 
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        // first pass maps numbers to the number of occurence 
        for (int n : nums1) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n)+1);
            } else {
                map.put(n, 1);
	    }
        }
        // second pass selects the intersection
        for (int n : nums2) {
            // it is important to check key existence first or map.get(key) might cause null pointer error
            if (map.containsKey(n) && map.get(n) > 0) {
                resultList.add(n);
                map.put(n, map.get(n)-1);
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
	    result[i] = resultList.get(i);
	}
        return result;
    }
}

// O(nlogn) time and O(n) space 
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> resultList = new ArrayList<>();
        int ix1 = 0, ix2 = 0;
        while (ix1 < nums1.length && ix2 < nums2.length) {
            if (nums1[ix1] < nums2[ix2]) {
                ix1++;
            } else if (nums1[ix1] > nums2[ix2]) {
                ix2++;
            } else {
                resultList.add(nums1[ix1]);
                ix1++;
                ix2++;
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
	    result[i] = resultList.get(i);
	}
        return result;
    }
}
