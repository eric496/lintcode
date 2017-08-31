/*
Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.

Notice
You may assume that the array is non-empty and the majority number always exist in the array.

Example
Given [1, 1, 1, 1, 2, 2, 2], return 1
*/

public class Solution {
    public int majorityNumber(ArrayList<Integer> nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = -1;
        int ix = -1;
        for(Integer i : nums) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
            if(map.get(i) > max) {
                max = map.get(i);
                ix = i;
            }
        }
        return ix;
    }
}
