/*
Given two arrays, write a function to compute their intersection.

Notice
    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.

Example
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
*/

/*
Thought process: 
    1. Similar to 547, but keep track of the number of appearance of each element.
       So use hash map instead of hash set to store <number, count> pairs.
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
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(Integer n : nums2) {
            if(map.containsKey(n)) {
                res.add(n);
                if(map.get(n) - 1 == 0) {
                    map.remove(n);
                } else {
                    map.put(n, map.get(n) - 1);   
                }
            }
        }
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++) result[i] = res.get(i);
        return result;
    }
}

/*
Follow-up questions:
    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to num2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/
