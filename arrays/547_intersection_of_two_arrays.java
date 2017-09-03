/*
Given two arrays, write a function to compute their intersection.

Notice
    Each element in the result must be unique.
    The result can be in any order.

Example
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
*/

/*
Thought process:
    1. Use two hash sets. Note that use hash set to store unique values as well
       because this allows to automatically remove duplicates added to the set.
*/

//O(n) time and O(n) space
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hash = new HashSet<Integer>();
        for(Integer n : nums1) hash.add(n);
        HashSet<Integer> res = new HashSet<Integer>();
        for(Integer n : nums2) {
            //Actually !res.contains(n) is not necessary because it is set. Leave it here for better understanding.
            if(hash.contains(n) && !res.contains(n)) res.add(n);
        }
        int[] result = new int[res.size()];
        int ix = 0;
        for(Integer n : res) result[ix++] = n;
        return result;
    }
}
