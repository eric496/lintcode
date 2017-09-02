/*
Given two arrays, write a function to compute their intersection.

Notice
    Each element in the result must be unique.
    The result can be in any order.

Example
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
*/

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hash = new HashSet<Integer>();
        for(Integer n : nums1) hash.add(n);
        HashSet<Integer> hashResult = new HashSet<Integer>();
        for(Integer n : nums2) {
            if(hash.contains(n) && !hashResult.contains(n)) hashResult.add(n);
        }
        int[] result = new int[hashResult.size()];
        int ix = 0;
        for(Integer n : hashResult) result[ix++] = n;
        return result;
    }
}
