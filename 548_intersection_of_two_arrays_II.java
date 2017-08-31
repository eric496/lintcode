/*
Given two arrays, write a function to compute their intersection.

Notice
    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.

Example
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
*/

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(Integer n : nums1) {
            if(map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for(Integer n : nums2) {
            if(map.containsKey(n) && map.get(n) > 0) {
                list.add(n);
                map.put(n, map.get(n) - 1);
            }
        }

        int[] result = new int[list.size()];
        int ix = 0;
        for(Integer n : list) result[ix++] = n;
        return result;
    }
}
